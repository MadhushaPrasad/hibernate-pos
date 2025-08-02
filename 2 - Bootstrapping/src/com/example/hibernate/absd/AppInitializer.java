package com.example.hibernate.absd;

import com.example.hibernate.absd.entity.Customer;
import com.example.hibernate.absd.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AppInitializer {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Customer kasun = new Customer("C001", "Kasun", "Kalutara");
        session.save(kasun);

        session.getTransaction().commit();

        System.out.println(session);
        session.close();
        sessionFactory.close();
    }
}
