package com.CME.backend.dto;

import java.math.BigDecimal;

public class CombinedStockDataDTO {
    // Stock Data fields
    private String symbol;
    private BigDecimal prevClose;
    private BigDecimal iep;
    private BigDecimal chng;
    private BigDecimal pctChng;
    private BigDecimal finalPrice;
    private BigDecimal finalQuantity;
    private BigDecimal value;
    private BigDecimal ffmCap;
    private BigDecimal nm52wH;
    private BigDecimal nm52wL;


    // Trade Info fields
    private BigDecimal tradedVolumeLakhs;
    private BigDecimal tradedValueCr;
    private BigDecimal totalMarketCapCr;
    private BigDecimal freeFloatMarketCapCr;
    private BigDecimal impactCost;
    private BigDecimal percentDeliverableTradedQuantity;
    private BigDecimal applicableMarginRate;
    private BigDecimal faceValue;

    // Price Info fields
    private BigDecimal week52High;
    private BigDecimal week52Low;
    private BigDecimal upperBand;
    private BigDecimal lowerBand;
    private String priceBand;
    private BigDecimal dailyVolatility;
    private BigDecimal annualisedVolatility;
    private BigDecimal tickSize;

    public CombinedStockDataDTO(){}

    public CombinedStockDataDTO(String symbol, BigDecimal prevClose, BigDecimal iep, BigDecimal chng, BigDecimal pctChng, BigDecimal finalPrice, BigDecimal finalQuantity, BigDecimal value, BigDecimal ffmCap, BigDecimal nm52wH, BigDecimal nm52wL, BigDecimal tradedVolumeLakhs, BigDecimal tradedValueCr, BigDecimal totalMarketCapCr, BigDecimal freeFloatMarketCapCr, BigDecimal impactCost, BigDecimal percentDeliverableTradedQuantity, BigDecimal applicableMarginRate, BigDecimal faceValue, BigDecimal week52High, BigDecimal week52Low, BigDecimal upperBand, BigDecimal lowerBand, String priceBand, BigDecimal dailyVolatility, BigDecimal annualisedVolatility, BigDecimal tickSize) {
        this.symbol = symbol;
        this.prevClose = prevClose;
        this.iep = iep;
        this.chng = chng;
        this.pctChng = pctChng;
        this.finalPrice = finalPrice;
        this.finalQuantity = finalQuantity;
        this.value = value;
        this.ffmCap = ffmCap;
        this.nm52wH = nm52wH;
        this.nm52wL = nm52wL;
        this.tradedVolumeLakhs = tradedVolumeLakhs;
        this.tradedValueCr = tradedValueCr;
        this.totalMarketCapCr = totalMarketCapCr;
        this.freeFloatMarketCapCr = freeFloatMarketCapCr;
        this.impactCost = impactCost;
        this.percentDeliverableTradedQuantity = percentDeliverableTradedQuantity;
        this.applicableMarginRate = applicableMarginRate;
        this.faceValue = faceValue;
        this.week52High = week52High;
        this.week52Low = week52Low;
        this.upperBand = upperBand;
        this.lowerBand = lowerBand;
        this.priceBand = priceBand;
        this.dailyVolatility = dailyVolatility;
        this.annualisedVolatility = annualisedVolatility;
        this.tickSize = tickSize;
    }


    // Getters and Setters
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