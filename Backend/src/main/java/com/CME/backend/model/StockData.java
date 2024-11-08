package com.CME.backend.model;

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
    private BigDecimal finalPrice;
    private BigDecimal finalQuantity;
    private BigDecimal value;
    private BigDecimal ffmCap;

    @Column(name = "nm_52w_h")
    private BigDecimal nm52wH;

    @Column(name = "nm_52w_l")
    private BigDecimal nm52wL;

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

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public BigDecimal getFinalQuantity() {
        return finalQuantity;
    }

    public void setFinalQuantity(BigDecimal finalQuantity) {
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

    public BigDecimal getNm52wH() {
        return nm52wH;
    }

    public void setNm52wH(BigDecimal nm52wH) {
        this.nm52wH = nm52wH;
    }

    public BigDecimal getNm52wL() {
        return nm52wL;
    }

    public void setNm52wL(BigDecimal nm52wL) {
        this.nm52wL = nm52wL;
    }
}
