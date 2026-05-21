package edu.citytech.counter.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.java.data.annotation.Column;

import io.micronaut.serde.annotation.SerdeImport;

@SerdeImport
public class Stock {

    @Column(index = "0")
    private int rank;
    @Column(index = "1")
    private String symbol;
    @Column(index = "2")
    private String companyName;
    @Column(index = "3")
    private float quantRating;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public float getQuantRating() {
        return quantRating;
    }

    public void setQuantRating(float quantRating) {
        this.quantRating = quantRating;
    }

    public float getsAAnalystRatings() {
        return sAAnalystRatings;
    }

    public void setsAAnalystRatings(float sAAnalystRatings) {
        this.sAAnalystRatings = sAAnalystRatings;
    }

    public float getWallStreetRatings() {
        return wallStreetRatings;
    }

    public void setWallStreetRatings(float wallStreetRatings) {
        this.wallStreetRatings = wallStreetRatings;
    }

    @JsonIgnore //gets rid of this data field in the data send
    public float getMarketCap() {
        return marketCap;
    }

        public float getMarketCapInBillions() {
        return marketCap / 1_000_000_000;
    }

    public void setMarketCap(float marketCap) {
        this.marketCap = marketCap;
    }

    public float getDivYield() {
        return divYield;
    }

    public void setDivYield(float divYield) {
        this.divYield = divYield;
    }

    public String getValuation() {
        return valuation;
    }

    public void setValuation(String valuation) {
        this.valuation = valuation;
    }

    public String getGrowth() {
        return growth;
    }

    public void setGrowth(String growth) {
        this.growth = growth;
    }

    public String getProfitability() {
        return profitability;
    }

    public void setProfitability(String profitability) {
        this.profitability = profitability;
    }

    public String getMomentum() {
        return momentum;
    }

    public void setMomentum(String momentum) {
        this.momentum = momentum;
    }

    public String getePSRev() {
        return ePSRev;
    }

    public void setePSRev(String ePSRev) {
        this.ePSRev = ePSRev;
    }

    @Column(index = "4")
    private float sAAnalystRatings;
    @Column(index = "5")
    private float wallStreetRatings;
    @Column(index = "6")
    private float marketCap;
    @Column(index = "7")
    private float divYield;
    @Column(index = "8")
    private String valuation;
    @Column(index = "9")
    private String growth;
    @Column(index = "10")
    private String profitability;
    @Column(index = "11")
    private String momentum;
    @Column(index = "12")
    private String ePSRev;

    @Override
    public String toString() {
        return "Stock [rank=" + rank + ", symbol=" + symbol + ", quantRating="
                + quantRating + ", marketCapInBillions="
                + getMarketCapInBillions() + ", divYield=" + divYield + "]";
    }

}
