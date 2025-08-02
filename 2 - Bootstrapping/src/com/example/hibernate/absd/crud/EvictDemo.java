package com.example.hibernate.absd.crud;

import com.example.hibernate.absd.entity.Customer;
import com.example.hibernate.absd.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EvictDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Customer c002 = session.get(Customer.class, "C002");
        // [Ruwan, Colombo]
        session.evict(c002); // detach state -> Hibernate
//      session.detach(c002); // detach state -> JPA
//        we can say to hibernate or JPA to don't observe c002 until any change
        c002.setName("Punchiya");

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
