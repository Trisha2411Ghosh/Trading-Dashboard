package com.CME.tradingdashboard.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
@Entity
@Table(name = "stock_data")
public class StockData {
    @Id
    private String symbol;

    private BigDecimal prevClose;
    private BigDecimal iep;
    private BigDecimal chng;
    private BigDecimal pctChng;
    private BigDecimal final_value;
    private Integer finalQuantity;
    private BigDecimal value;
    private BigDecimal ffmCap;
    private BigDecimal finalPrice; // Added final price field
    private BigDecimal dayHigh;     // Added day high field
    private BigDecimal dayLow;      // Added day low field

    @Column(name = "week_52_high")
    private BigDecimal week_52_high;

    @Column(name = "week_52_high")
    private BigDecimal week_52_low;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getPrevClose() {
        return prevClose;
    }

    public void setPrevClose(BigDecimal prevClose) {
        this.prevClose = prevClose;
    }

    public BigDecimal getIep() {
        return iep;
    }

    public void setIep(BigDecimal iep) {
        this.iep = iep;
    }

    public BigDecimal getChng() {
        return chng;
    }

    public void setChng(BigDecimal chng) {
        this.chng = chng;
    }

    public BigDecimal getPctChng() {
        return pctChng;
    }

    public void setPctChng(BigDecimal pctChng) {
        this.pctChng = pctChng;
    }

    public BigDecimal getFinalvalue() {
        return final_value;
    }

    public void setFinalValue(BigDecimal final_value) {
        this.final_value = final_value;
    }

    public Integer getFinalQuantity() {
        return finalQuantity;
    }

    public void setFinalQuantity(int finalQuantity) {
        this.finalQuantity = finalQuantity;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getFfmCap() {
        return ffmCap;
    }

    public void setFfmCap(BigDecimal ffmCap) {
        this.ffmCap = ffmCap;
    }

    public BigDecimal getwwek52high() {
        return week_52_high;
    }

    public void setweek52high(BigDecimal week_52_high) {
        this.week_52_high = week_52_high;
    }

    public BigDecimal getWeek52low() {
        return week_52_low;
    }

    public void setweek52low(BigDecimal nm52wL) {
        this.week_52_low = week_52_low;
    }
    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public BigDecimal getDayHigh() {
        return dayHigh;
    }

    public void setDayHigh(BigDecimal dayHigh) {
        this.dayHigh = dayHigh;
    }

    public BigDecimal getDayLow() {
        return dayLow;
    }

    public void setDayLow(BigDecimal dayLow) {
        this.dayLow = dayLow;
    }
}