package com.CME.tradingdashboard.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "trade_info")
public class TradeInfo {
    @Id
    private String trade_id;

    private String instrument_id;
    private BigDecimal tradedVolumeLakhs;
    private BigDecimal tradedValueCr;
    private BigDecimal totalMarketCapCr;
    private BigDecimal ffmCap;
    private BigDecimal impactCost;
    private BigDecimal percentDeliverableTradedQuantity;
    private BigDecimal applicableMarginRate;
    private BigDecimal faceValue;

    // Getters and Setters
    public String getTrade_id() {
        return trade_id;
    }

    public void setTrade_id(String trade_id) {
        this.trade_id = trade_id;
    }

    public String getInstrument_id() {
        return instrument_id;
    }

    public void setInstrument_id(String instrument_id) {
        this.instrument_id = instrument_id;
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

    public BigDecimal getFfmCap() {
        return ffmCap;
    }

    public void setFfmCap(BigDecimal ffmCap) {
        this.ffmCap = ffmCap;
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