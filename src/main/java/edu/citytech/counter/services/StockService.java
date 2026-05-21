package edu.citytech.counter.services;
//Developer: Usman, Muhammad | @AbuTalha63 on GitHub
import java.util.ArrayList;
import java.util.List;
import com.learning.java.data.repository.ExcelRepository;

import edu.citytech.counter.dto.Stock;
import jakarta.inject.Singleton;
@Singleton

public class StockService {

    private static String DIR = System.getenv("CST_3613_DATA");
    private static List<Stock> list = new ArrayList<>();

    static {
		String fileName = DIR + "/BestEnergyStocks2024-10-25.xlsx";
        int sheetNumber = 0, skip = 1;	
		
		var repository = new ExcelRepository<Stock>(fileName, sheetNumber, skip);		
		repository.findAll(Stock.class, list::add);

        for (Stock energyStock : list) {
            System.out.println(energyStock);
        }	
	}

    public int size() {
        return list.size();
    }

    public List<Stock> getDividendStocks() {
        
        List<Stock> divList = new ArrayList<>();

        for (Stock energyStock : list) {
            if (energyStock.getDivYield() > 0 ){
                divList.add(energyStock);
            }
        }        
        return divList;
    }

    public List<Stock> getMarketCapInBillions() {

        List<Stock> billClub = new ArrayList<>();

        for (Stock energyStock : list) {
            if (energyStock.getMarketCapInBillions() >= 1){   //Previously: you did GetMarketCap() > 1_000_000_000 | WRONG
                billClub.add(energyStock);                    //Now: GetMarketCapInBillions() >= 1 | CORRECT
            }            
        }
        return billClub;
    }
}