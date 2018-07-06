package org.bizmailov.hibernate.annotation;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

@Entity
class B {

  @Id
  @Column
  public String id;

  @Column
  public String username;

  @ManyToMany(fetch = FetchType.EAGER, mappedBy = "bDomains")
  public Set<A> aDomains;

  @Version
  public int version;
}
