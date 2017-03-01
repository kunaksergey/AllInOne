package ua.shield.hw01032017.service;

import ua.shield.hw01032017.entity.Stock;

import java.util.List;

/**
 * Created by sa on 01.03.17.
 */
public class StockService implements IService<Stock>{
    private StockDao stockDao=new StockDao();
    private static StockService stockService;

    public static StockService newInstance() {
        if(stockService==null){
            stockService=new StockService();
        }
        return stockService;
    }

    @Override
    public void save(Stock stock) {
        stockDao.save(stock);
    }
    @Override
    public List<Stock> findAll() {
        return stockDao.findAll();
    }
    @Override
    public Stock findById(int id) {
        return stockDao.findById(id);
    }

    @Override
    public void delete(Stock obj) {
        stockDao.delete(obj);
    }
}
