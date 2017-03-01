package ua.shield.hw01032017.service;

import org.hibernate.Session;
import ua.shield.hw01032017.entity.Stock;

import java.util.List;
import java.util.function.Function;

/**
 * Created by sa on 01.03.17.
 */
public class StockDao {

      public void save(Stock stock) {
        Session session = HibernateUtil.openSession();
        session.save(stock);
        session.close();
    }

    public List<Stock> findAll() {
        Session session = HibernateUtil.openSession();
        List list = (List<Stock>) session.createQuery(" from Stock").list();
        session.close();
        return list;
    }

    public Stock findById(int id) {
        Session session = HibernateUtil.openSession();
        Stock stock=session.find(Stock.class,id);
        session.close();
        return stock;
    }

    public void delete(Stock stock) {
        Session session = HibernateUtil.openSession();
        session.delete(stock);
        session.close();
    }



}
