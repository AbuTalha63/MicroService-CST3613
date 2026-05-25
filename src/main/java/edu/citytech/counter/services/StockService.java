package edu.citytech.counter.services;
//Developer: Usman, Muhammad | @AbuTalha63 on GitHub
import java.util.ArrayList;
import java.util.List;
import com.learning.java.data.repository.ExcelRepository;

import edu.citytech.counter.dto.Category;
import edu.citytech.counter.dto.Stock;
import jakarta.inject.Singleton;
@Singleton

public class StockService {

    private static String DIR = System.getenv("CST_3613_DATA");
    private static List<Stock> list = new ArrayList<>();
    private static List<Category> categories = new ArrayList<>();

    static {

        categories.add(new Category(1, "Energy"));
        categories.add(new Category(1, "REITs"));
        categories.add(new Category(1, "ConsumerStaples"));
        categories.add(new Category(1, "Gaming"));

        String[] files = {"Energy", "REITs", "ConsumerStaples", "Gaming"};

        int sheetNumber = 0, skip = 1;

        for (String aFile : files) {

            String fullName = DIR + "/" + aFile + ".xlsx";
            var repository = new ExcelRepository<Stock>(fullName, sheetNumber, skip);		
		    repository.findAll(Stock.class, list::add);
        }
		
		

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

        public List<Stock> getAll() {
        return list;
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