package ua.shield.hw01032017;
import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;
import ua.shield.hw01032017.entity.Stock;
import ua.shield.hw01032017.service.StockDao;
import ua.shield.hw01032017.service.StockService;

/**
 * Created by sa on 02.03.17.
 */
public class TestHibernate {

    @Test
    public void testFindById(){
        StockDao stockDao=mock(StockDao.class);
        when(stockDao.findById(1)).thenReturn(new Stock(1,"one","one"));
        StockService stockService=new StockService();
        stockService.setStockDao(stockDao);
        Assert.assertEquals(stockService.findById(1),new Stock(1,"one","one"));
    }
    
}
