package com.example.hibernate.absd.crud;

import com.example.hibernate.absd.entity.Customer;
import com.example.hibernate.absd.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RemoveDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        // manage -> delete -> remove
        Customer c002 = session.get(Customer.class, "C002");
        session.remove(c002);

//        session.save(c002);


        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }
}
