package org.bizmailov.hibernate.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AnnotationMain {

  public static void main(String[] args) {
    SessionFactory sessionFactory = new Configuration().configure("annotation-hibernate.cfg.xml").buildSessionFactory();
    Session session = sessionFactory.openSession();
    session.beginTransaction();

    A a = session.get(A.class, "1");
    int versionBefore = a.version;

    B b = new B();
    b.id = "48";
    b.username = "asd";

    a.bDomains.add(b);

    session.save(a);
    session.flush();

    int versionAfter = a.version;
    System.out.println("version before: " + versionBefore);
    System.out.println("version after: " + versionAfter);

    session.getTransaction().rollback();
    sessionFactory.close();
  }

}
