package ua.shield.hw01032017.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.function.Function;

/**
 * Created by sa on 01.03.17.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session openSession(){
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        return session;
    }

    public static void closeSession(Session session){
        session.getTransaction().commit();
        session.close();
    }

    public static void shutDown(){
        if(sessionFactory!=null && sessionFactory.isOpen()) {
            sessionFactory.close();
        }
    }

    public static<R> R execute(Function<Session,R> function){
        Session session=openSession();
        R obj= function.apply(session);
        closeSession(session);
        return obj;
    }
}