package org.bizmailov.hibernate.mixed;

import java.util.Set;

class B {

  public String id;

  public String username;

  public Set<A> aDomains;

  public int version;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Set<A> getaDomains() {
    return aDomains;
  }

  public void setaDomains(Set<A> aDomains) {
    this.aDomains = aDomains;
  }

  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }

}
