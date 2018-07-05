package org.bizmailov.hibernate.mixed;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
class A {

  public String id;

  public String notes;

  public Set<B> bDomains;

  public int version;

  @Id
  @Column
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Column
  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(name = "A_B",
      joinColumns = { @JoinColumn(name = "A_ID") },
      inverseJoinColumns = { @JoinColumn(name = "B_ID") })
  public Set<B> getbDomains() {
    return bDomains;
  }

  public void setbDomains(Set<B> bDomains) {
    this.bDomains = bDomains;
  }

  @Column
  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }

}
