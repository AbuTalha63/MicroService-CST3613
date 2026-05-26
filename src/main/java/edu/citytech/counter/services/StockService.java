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
        categories.add(new Category(2, "REITS"));
        categories.add(new Category(4, "ConsumerStaples"));
        categories.add(new Category(8, "Gaming"));


        int sheetNumber = 0, skip = 1;

        for (var category : categories) {

            String fullName = DIR + "/" + category.category() + ".xlsx";
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

        public List<Stock> filter(int code) {

            List<Stock> filtredList = new ArrayList<>(); 

            for (Category category : categories) {

                boolean display = (category.code() & code) > 0;
                if (display) {
                    var newList = list.stream()
                                       .filter(e -> e.getCategory().equals(category.category() ))
                                       .toList();

                    filtredList.addAll(newList);
                }
            }
        return filtredList;
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