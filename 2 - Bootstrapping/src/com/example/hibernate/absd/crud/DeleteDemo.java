package com.example.hibernate.absd.crud;

import com.example.hibernate.absd.entity.Customer;
import com.example.hibernate.absd.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
//      ==================================================================
        Customer c002 = session.getReference(Customer.class, "C002");
        session.delete(c002); // delete customer who has C002 id
//        ==================================================================

//        save again deleted customer
        session.save(c002);


        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }
}
