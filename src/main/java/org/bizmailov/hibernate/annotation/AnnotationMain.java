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
    int version1 = a.version;

    a.notes = new String("notes");

    B b = new B();
    b.id = "48";
    b.username = "asd";

    a.bDomains.add(b);

    session.save(a);
    session.flush();

    int version2 = a.version;
    System.out.println("version1: " + version1);
    System.out.println("version2: " + version2);

    session.getTransaction().rollback();
    sessionFactory.close();
  }

}
