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
        System.out.println("**********************");
        Stock stock = stockService.findById(67);
        System.out.println(stock);
        if(stock!=null) {
        stock.setCode("777");
        System.out.println(stock);

            stockService.save(stock);
        }
        stock = stockService.findById(67);
        System.out.println(stock);
        System.out.println("**********************");

        stockService.findAll().forEach(System.out::println);
       /* stockService.deleteAll();*/

        stockService.shutdown();

    }
}
