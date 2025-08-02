package com.example.hibernate.absd.crud;

import com.example.hibernate.absd.entity.Customer;
import com.example.hibernate.absd.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public class SaveDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

//        ============= Console session =============
        System.out.println(session);

//       ======== create a customer =========

        session.beginTransaction();

        Customer madhusha = new Customer("C001", "Madhusha", "Kalutara");
        Serializable savedDetails = session.save(madhusha);

        System.out.println(savedDetails);

        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }
}
