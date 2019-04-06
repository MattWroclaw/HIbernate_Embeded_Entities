package sda.hibernate;

import org.hibernate.Session;

public class Zadanie1roz {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.close();
    }
}
