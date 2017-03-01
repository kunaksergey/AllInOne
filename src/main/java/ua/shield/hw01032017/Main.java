package ua.shield.hw01032017;

import ua.shield.hw01032017.entity.Stock;
import ua.shield.hw01032017.service.StockService;

/**
 * Created by sa on 01.03.17.
 */
public class Main {
    public static void main(String[] args) {
        StockService stockService=StockService.newInstance();
        stockService.save(new Stock("1234","one"));
        stockService.save(new Stock("1312d","two"));
        stockService.save(new Stock("2sada","three"));
        stockService.findAll().forEach(System.out::println);
        Stock stock = stockService.findById(1);
        stock.setCode("66666");
        stockService.save(stock);
        stockService.findAll().forEach(System.out::println);

    }
}
