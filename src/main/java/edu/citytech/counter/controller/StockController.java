package edu.citytech.counter.controller;
//Developer: Usman, Muhammad | @AbuTalha63 on GitHub
import java.util.HashMap;
import java.util.Map;

import edu.citytech.counter.services.REITSService;
import edu.citytech.counter.services.StockService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;


@Controller("/stocks")
public class StockController {

    @Inject
    StockService service;

    @Inject
    REITSService reitsService;

    @Get(value = "/{type}")
    public Object getAll(String type) {

        Map<String, Object> map = new HashMap<>();
        var data = type.equals("dividends") ? service.getDividendStocks() : service.getAll();
        
        map.put("data", data);
        map.put("size", data.size());

        System.out.println("Developer: Usman, Muhammad");

        return map;
    }

    @Get(value = "/code/{code}")
    public Object getByCode(int code) {

        Map<String, Object> map = new HashMap<>();
        var data = service.filter(code);
        map.put("data", data);
        map.put("size", data.size());

        return map;
    }


  @Get(value = "/reits")
    public Object getAllReits() {

        Map<String, Object> map = new HashMap<>();
        var data = reitsService.findAll();
        map.put("reitsData", data);
        map.put("size", data.size());
        
        return map;
    }
}