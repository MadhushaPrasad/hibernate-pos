package com.example.hibernate.absd.crud;

import com.example.hibernate.absd.entity.Customer;
import com.example.hibernate.absd.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GetDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Customer c001 = session.get(Customer.class, "C001");
        System.out.println(c001);

        System.out.println("-------------------");

        Customer anotherC001 = session.get(Customer.class, "C001");
        System.out.println(anotherC001);

        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }
}
