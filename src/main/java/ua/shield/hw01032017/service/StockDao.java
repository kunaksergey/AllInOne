package ua.shield.hw01032017.service;

import org.hibernate.Session;
import ua.shield.hw01032017.entity.Stock;

import javax.persistence.criteria.From;
import java.util.List;
import java.util.function.Function;

/**
 * Created by sa on 01.03.17.
 */
public class StockDao {

      public void save(Stock stock) {
        /*Session session = HibernateUtil.openSession();
        session.saveOrUpdate(stock);
        session.flush();
        HibernateUtil.closeSession(session);*/
        HibernateUtil.execute((Session s)->{s.saveOrUpdate(stock);s.flush();return null;});
       }

    public List<Stock> findAll() {
        /*Session session = HibernateUtil.openSession();
        List list = (List<Stock>) session.createQuery(" from Stock").list();
        HibernateUtil.closeSession(session);
        return list;*/
        return HibernateUtil.execute((Session s)->(List<Stock>) s.createQuery(" from Stock").list());
    }

    public Stock findById(int id) {
       /* Session session = HibernateUtil.openSession();
        Stock stock=session.find(Stock.class,id);
        HibernateUtil.closeSession(session);
        return stock;*/
        return HibernateUtil.execute((Session s)->s.find(Stock.class,id));
    }

    public void delete(Stock stock) {
        /*Session session = HibernateUtil.openSession();
        session.delete(stock);
        HibernateUtil.closeSession(session);*/
        HibernateUtil.execute((Session s)->{s.delete(stock);return null;});
    }

    public int deleteAll() {
        /*final String sql="delete from stock";
        Session session = HibernateUtil.openSession();
        int result=session.createQuery("delete from Stock").executeUpdate();
        HibernateUtil.closeSession(session);
        return result;*/
        return HibernateUtil.execute((Session s)->s.createQuery("delete from Stock").executeUpdate());
    }

    public void shutdown() {
        HibernateUtil.shutDown();
    }
}
