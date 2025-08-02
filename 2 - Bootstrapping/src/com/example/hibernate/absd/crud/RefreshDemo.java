package com.example.hibernate.absd.crud;

import com.example.hibernate.absd.entity.Customer;
import com.example.hibernate.absd.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RefreshDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        //hibernate.allow_refresh_detached_entity=false 24.22 (Userguide)

        Customer kasun = session.get(Customer.class, "C001");
        session.detach(kasun);
        System.out.println(kasun);  // Kasun+
        kasun.setName("Kasun");
        session.refresh(kasun);
        System.out.println(kasun);  // Kasun+
        System.out.println(session.contains(kasun));
        kasun.setName("Kasun");

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }

}
