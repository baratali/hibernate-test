package org.bizmailov.hibernate.xml;

import java.util.Set;

class A {

  public String id;

  public String notes;

  public Set<B> bDomains;

  public int version;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public Set<B> getbDomains() {
    return bDomains;
  }

  public void setbDomains(Set<B> bDomains) {
    this.bDomains = bDomains;
  }

  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }

}
