package edu.citytech.counter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.citytech.counter.dto.Stock;
import edu.citytech.counter.services.StockService;

public class T2_EnergyStocks {

    @Test
    @DisplayName("All Count")
    void t1() {

        System.out.println(System.getenv("CST_3613_DATA"));

        StockService service = new StockService();

        int actual = service.size();
        int expected = 482;
        assertEquals(expected, actual);

        System.out.println("Count: " + service.size());
        System.out.println("Developer: Usman, Muhammad");
    }

    @Test
    @DisplayName("Has Dividend payout count")
    void t2() {

        StockService service = new StockService();
        List<Stock> list = service.getDividendStocks();

        int actual = list.size();
        int expected = 299;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Market cap > Billion")
    void t3() {

        StockService service = new StockService();
        List<Stock> list = service.getMarketCapInBillions();

        int actual = list.size();
        int expected = 330;

        list.forEach(System.out::println);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("All stocks using code")
    void t4() {
        StockService service = new StockService();

        int actual = service.filter(15).size();
        int expected = 482;
        assertEquals(expected, actual);

        System.out.println("Count: " + service.size());
        System.out.println("Developer: Usman, Muhammad");
    }

}





