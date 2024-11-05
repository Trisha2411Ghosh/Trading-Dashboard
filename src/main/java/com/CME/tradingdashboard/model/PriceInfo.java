package com.CME.tradingdashboard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "price_info")
public class PriceInfo {
    @Id
    private String symbol;

    private BigDecimal week52High;
    private BigDecimal week52Low;
    private BigDecimal upperBand;
    private BigDecimal lowerBand;
    private String priceBand;
    private BigDecimal dailyVolatility;
    private BigDecimal annualisedVolatility;
    private BigDecimal tickSize;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getWeek52High() {
        return week52High;
    }

    public void setWeek52High(BigDecimal week52High) {
        this.week52High = week52High;
    }

    public BigDecimal getWeek52Low() {
        return week52Low;
    }

    public void setWeek52Low(BigDecimal week52Low) {
        this.week52Low = week52Low;
    }

    public BigDecimal getUpperBand() {
        return upperBand;
    }

    public void setUpperBand(BigDecimal upperBand) {
        this.upperBand = upperBand;
    }

    public BigDecimal getLowerBand() {
        return lowerBand;
    }

    public void setLowerBand(BigDecimal lowerBand) {
        this.lowerBand = lowerBand;
    }

    public String getPriceBand() {
        return priceBand;
    }

    public void setPriceBand(String priceBand) {
        this.priceBand = priceBand;
    }

    public BigDecimal getDailyVolatility() {
        return dailyVolatility;
    }

    public void setDailyVolatility(BigDecimal dailyVolatility) {
        this.dailyVolatility = dailyVolatility;
    }

    public BigDecimal getAnnualisedVolatility() {
        return annualisedVolatility;
    }

    public void setAnnualisedVolatility(BigDecimal annualisedVolatility) {
        this.annualisedVolatility = annualisedVolatility;
    }

    public BigDecimal getTickSize() {
        return tickSize;
    }

    public void setTickSize(BigDecimal tickSize) {
        this.tickSize = tickSize;
    }
}