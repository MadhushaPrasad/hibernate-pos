package com.example.hibernate.absd.crud;

import com.example.hibernate.absd.entity.Customer;
import com.example.hibernate.absd.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MergeDemo2 {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Customer c005 = new Customer("C005", "Dilisha", "Panadura");
        Customer clonedObject = (Customer) session.merge(c005);// SELECT
        System.out.println(clonedObject);
        c005.setAddress("Galle");

        session.getTransaction().commit();  // INSERT
        session.close();
        sessionFactory.close();

    }

}
