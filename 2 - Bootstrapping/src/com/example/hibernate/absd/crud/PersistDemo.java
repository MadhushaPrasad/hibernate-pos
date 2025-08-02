package com.example.hibernate.absd.crud;

import com.example.hibernate.absd.entity.Customer;
import com.example.hibernate.absd.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PersistDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

//        this type used for JPA data save
        session.beginTransaction();

        Customer prasad = new Customer("C002", "Prasad", "Gamagoda");
        session.persist(prasad);

        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }
}
