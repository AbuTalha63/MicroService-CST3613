package edu.citytech.counter.dto;

import io.micronaut.serde.annotation.SerdeImport;

@SerdeImport
public class REITS { 
    private int rank;
    private String symbol;
    private float marketCapInBillions;

    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public float getMarketCapInBillions() {
        return marketCapInBillions;
    }
    public void setMarketCapInBillions(float marketCapInBillions) {
        this.marketCapInBillions = marketCapInBillions;
    }

    @Override
    public String toString() {
        return "REITS [rank=" + rank + ", symbol=" + symbol + ", marketCapInBillions=" + marketCapInBillions + "]";
    }
}