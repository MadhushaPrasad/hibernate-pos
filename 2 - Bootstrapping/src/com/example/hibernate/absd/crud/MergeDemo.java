package com.example.hibernate.absd.crud;

import com.example.hibernate.absd.entity.Customer;
import com.example.hibernate.absd.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MergeDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Customer c002 = session.get(Customer.class, "C002");
        session.detach(c002);
        c002.setName("Punchiya");
//        Customer anotherC002 = session.get(Customer.class, "C002");
        Customer clonedObject = (Customer) session.merge(c002);
//        clonedObject.setName("Punchiya+");

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

//        System.out.println("----------------");
//        Customer anotherC002 = session.get(Customer.class, "C002");
//        System.out.println(anotherC002  == c002);



    }

}
