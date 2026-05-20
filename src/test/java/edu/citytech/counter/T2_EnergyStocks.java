package edu.citytech.counter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.citytech.counter.services.EnergyStockService;

public class T2_EnergyStocks {
    
    @Test
    @DisplayName("t1")
    void t1() {

        System.out.println(System.getenv("CST_3613_DATA"));


        EnergyStockService service = new EnergyStockService();
        int actual = service.size();
        int expected = 232;

        assertEquals(actual, expected);
    }
}