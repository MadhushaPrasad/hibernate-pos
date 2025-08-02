package com.example.hibernate.absd.crud;

import com.example.hibernate.absd.entity.Customer;
import com.example.hibernate.absd.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

//      ==================================================================
        session.beginTransaction();
        Customer c002 = session.getReference(Customer.class, "C002");
        System.out.println(c002);
        c002.setAddress("Kaduwela");
        session.getTransaction().commit();
//      ==================================================================

        session.close();
        sessionFactory.close();
    }
}
