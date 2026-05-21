package edu.citytech.counter.controller;
//Developer: Usman, Muhammad | @AbuTalha63 on GitHub

import java.util.HashMap;
import java.util.Map;

import edu.citytech.counter.services.EnergyStockService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;


@Controller("/stocks")
public class EnergyStockController {

    @Inject
    EnergyStockService service;

    @Get(value = "/dividends")
    public Object getAll() {

        Map<String, Object> map = new HashMap<>();
        var data = service.getDividendStocks();
        map.put("data", service.getDividendStocks());
        map.put("size", data.size());

        System.out.println("Developer: Usman, Muhammad");

        return map;
    }
}