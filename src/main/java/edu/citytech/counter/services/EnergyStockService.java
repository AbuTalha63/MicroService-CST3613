package edu.citytech.counter.services;
//Developer: Usman, Muhammad | @AbuTalha63 on GitHub
import java.util.ArrayList;
import java.util.List;
import com.learning.java.data.repository.ExcelRepository;

import edu.citytech.counter.dto.EnergyStock;


public class EnergyStockService {

    private static String DIR = System.getenv("CST_3613_DATA");
    private static List<EnergyStock> list = new ArrayList<>();

    static {
		String fileName = DIR + "/BestEnergyStocks2024-10-25.xlsx";
        int sheetNumber = 0, skip = 1;	
		
		var repository = new ExcelRepository<EnergyStock>(fileName, sheetNumber, skip);		
		repository.findAll(EnergyStock.class, list::add);

        for (EnergyStock energyStock : list) {
            System.out.println(energyStock);
        }	
	}

    public int size() {
        return list.size();
    }

    public List<EnergyStock> getDividendStocks() {
        
        List<EnergyStock> divList = new ArrayList<>();

        for (EnergyStock energyStock : list) {
            if (energyStock.getDivYield() > 0 ){
                divList.add(energyStock);
            }
        }        
        return divList;
    }

    public List<EnergyStock> getMarketCapInBillions() {

        List<EnergyStock> billClub = new ArrayList<>();

        for (EnergyStock energyStock : list) {
            if (energyStock.getMarketCap() > 1_000_000_000){   //Since the getMarketCapInBillions method returns the marketCap,
                billClub.add(energyStock);                      //just divided by a Billion, we must utilize the regular getMarketCap method
            }            
        }
        return billClub;
    }
}