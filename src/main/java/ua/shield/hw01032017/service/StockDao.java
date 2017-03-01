package ua.shield.hw01032017.service;

import org.hibernate.Session;
import ua.shield.hw01032017.entity.Stock;

import java.util.List;

/**
 * Created by sa on 01.03.17.
 */
public class StockDao {

      public void save(Stock stock) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(stock);
        session.getTransaction().commit();
        session.close();
    }

    public List<Stock> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List list = (List<Stock>) session.createQuery(" from Stock").list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public Stock findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Stock stock=session.find(Stock.class,id);
        session.getTransaction().commit();
        session.close();
        return stock;
    }

    public void delete(Stock stock) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(stock);
        session.getTransaction().commit();
        session.close();
    }
}
