package org.bizmailov.hibernate.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class XmlMain {

  public static void main(String[] args) {
    SessionFactory sessionFactory = new Configuration().configure("xml-hibernate.cfg.xml").buildSessionFactory();
    Session session = sessionFactory.openSession();
    session.beginTransaction();

    A a = session.get(A.class, "1");
    int version1 = a.getVersion();

    a.notes = new String("notes");

    B b = new B();
    b.id = "4987";
    b.username = "asd";

    // no cascade, save manually
    session.save(b);

    a.bDomains.add(b);

    session.save(a);
    session.flush();

    int version2 = a.getVersion();
    System.out.println("version1: " + version1);
    System.out.println("version2: " + version2);

    session.getTransaction().rollback();
    sessionFactory.close();
  }

  /*
  without manual save of b:
    Hibernate: update RDBDS.A set VERSION=?, NOTES=? where ID=? and VERSION=?
    Hibernate: insert into RDBDS.A_B (A_ID, B_ID) values (?, ?)
    ORA-02291: integrity constraint (RDBDS.B_FK) violated - parent key not found
  */

  /*
  with manual save of b:
    Hibernate: insert into RDBDS.B (VERSION, USERNAME, ID) values (?, ?, ?)
    Hibernate: update RDBDS.A set VERSION=?, NOTES=? where ID=? and VERSION=?
    Hibernate: insert into RDBDS.A_B (A_ID, B_ID) values (?, ?)
  */
}
