package org.bizmailov.hibernate.annotation;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

@Entity
class A {

  @Id
  @Column
  public String id;

  @Column
  public String notes;

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(name = "A_B",
      joinColumns = { @JoinColumn(name = "A_ID") },
      inverseJoinColumns = { @JoinColumn(name = "B_ID") })
  public Set<B> bDomains;

  @Version
  public int version;
}
