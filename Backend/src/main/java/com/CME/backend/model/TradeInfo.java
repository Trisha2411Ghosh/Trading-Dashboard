package com.CME.backend.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "trade_info")
public class TradeInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String symbol;
    private BigDecimal tradedVolumeLakhs;
    private BigDecimal tradedValueCr;
    private BigDecimal totalMarketCapCr;
    private BigDecimal freeFloatMarketCapCr;
    private BigDecimal impactCost;
    private BigDecimal percentDeliverableTradedQuantity;
    private BigDecimal applicableMarginRate;
    private BigDecimal faceValue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getTradedVolumeLakhs() {
        return tradedVolumeLakhs;
    }

    public void setTradedVolumeLakhs(BigDecimal tradedVolumeLakhs) {
        this.tradedVolumeLakhs = tradedVolumeLakhs;
    }

    public BigDecimal getTradedValueCr() {
        return tradedValueCr;
    }

    public void setTradedValueCr(BigDecimal tradedValueCr) {
        this.tradedValueCr = tradedValueCr;
    }

    public BigDecimal getTotalMarketCapCr() {
        return totalMarketCapCr;
    }

    public void setTotalMarketCapCr(BigDecimal totalMarketCapCr) {
        this.totalMarketCapCr = totalMarketCapCr;
    }

    public BigDecimal getFreeFloatMarketCapCr() {
        return freeFloatMarketCapCr;
    }

    public void setFreeFloatMarketCapCr(BigDecimal freeFloatMarketCapCr) {
        this.freeFloatMarketCapCr = freeFloatMarketCapCr;
    }

    public BigDecimal getImpactCost() {
        return impactCost;
    }

    public void setImpactCost(BigDecimal impactCost) {
        this.impactCost = impactCost;
    }

    public BigDecimal getPercentDeliverableTradedQuantity() {
        return percentDeliverableTradedQuantity;
    }

    public void setPercentDeliverableTradedQuantity(BigDecimal percentDeliverableTradedQuantity) {
        this.percentDeliverableTradedQuantity = percentDeliverableTradedQuantity;
    }

    public BigDecimal getApplicableMarginRate() {
        return applicableMarginRate;
    }

    public void setApplicableMarginRate(BigDecimal applicableMarginRate) {
        this.applicableMarginRate = applicableMarginRate;
    }

    public BigDecimal getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(BigDecimal faceValue) {
        this.faceValue = faceValue;
    }
}
