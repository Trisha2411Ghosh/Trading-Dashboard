package com.CME.tradingdashboard.repository;

//import com.CME.tradingdashboard.model.Company;
import com.CME.tradingdashboard.model.PriceInfo;
import com.CME.tradingdashboard.model.StockData;
import com.CME.tradingdashboard.model.TradeInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClickhouseRepository {
    private final JdbcTemplate jdbcTemplate;

    public ClickhouseRepository(@Qualifier("clickhouseJdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Fetch all from stock_data
    public List<StockData> findAllStockData() {
        String sql = "SELECT symbol, prev_close, iep, chng, pct_chng, final_value, final_quantity, value, ffm_cap, week_52_high, week_52_low,final_price,day_high,day_low FROM stock_data";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            StockData stockData = new StockData();
            stockData.setSymbol(rs.getString("symbol"));
            stockData.setPrevClose(rs.getBigDecimal("prev_close"));
            stockData.setIep(rs.getBigDecimal("iep"));
            stockData.setChng(rs.getBigDecimal("chng"));
            stockData.setPctChng(rs.getBigDecimal("pct_chng"));
            stockData.setFinalValue(rs.getBigDecimal("final_value"));
            stockData.setFinalQuantity(rs.getInt("final_quantity"));
            stockData.setValue(rs.getBigDecimal("value"));
            stockData.setFfmCap(rs.getBigDecimal("ffm_cap"));
            stockData.setweek52high(rs.getBigDecimal("week_52_high"));
            stockData.setweek52low(rs.getBigDecimal("week_52_low"));
            stockData.setFinalPrice(rs.getBigDecimal("final_price"));   // Added final_price
            stockData.setDayHigh(rs.getBigDecimal("day_high"));         // Added day_high
            stockData.setDayLow(rs.getBigDecimal("day_low"));
            return stockData;
        });
    }

    //    fetch a specific symbol from stockdata
    public StockData findStockDataBySymbol(String symbol) {
        String sql = "SELECT symbol, prev_close, iep, chng, pct_chng, final, final_quantity, value, ffm_cap, week_52_high, week_52_low,final_price,day_high,day_low FROM stock_data WHERE LOWER(symbol) = LOWER(?)";
        List<StockData> result = jdbcTemplate.query(sql, new Object[]{symbol}, (rs, rowNum) -> {
            StockData stockData = new StockData();
            stockData.setSymbol(rs.getString("symbol"));
            stockData.setPrevClose(rs.getBigDecimal("prev_close"));
            stockData.setIep(rs.getBigDecimal("iep"));
            stockData.setChng(rs.getBigDecimal("chng"));
            stockData.setPctChng(rs.getBigDecimal("pct_chng"));
            stockData.setFinalValue(rs.getBigDecimal("final"));
            stockData.setFinalQuantity(rs.getInt("final_quantity"));
            stockData.setValue(rs.getBigDecimal("value"));
            stockData.setFfmCap(rs.getBigDecimal("ffm_cap"));
            stockData.setFinalPrice(rs.getBigDecimal("final_price"));   // Added final_price
            stockData.setDayHigh(rs.getBigDecimal("day_high"));         // Added day_high
            stockData.setDayLow(rs.getBigDecimal("day_low"));
            return stockData;
        });
        return result.isEmpty() ? null : result.get(0); // return null if not found
    }

    // Fetch trade info for a specific symbol
    public TradeInfo findTradeInfoBySymbol(String symbol) {
        String sql = "SELECT * FROM trade_info WHERE LOWER(symbol) = LOWER(?)";
        List<TradeInfo>result =  jdbcTemplate.query(sql, new Object[]{symbol}, (rs, rowNum) -> {
            TradeInfo tradeInfo = new TradeInfo();
            tradeInfo.setId(rs.getInt("id"));
            tradeInfo.setSymbol(rs.getString("symbol")); // Ensures symbol is set
            tradeInfo.setTradedVolumeLakhs(rs.getBigDecimal("traded_volume_lakhs"));
            tradeInfo.setTradedValueCr(rs.getBigDecimal("traded_value_cr"));
            tradeInfo.setTotalMarketCapCr(rs.getBigDecimal("total_market_cap_cr"));
            tradeInfo.setFreeFloatMarketCapCr(rs.getBigDecimal("ffm_cap"));
            tradeInfo.setImpactCost(rs.getBigDecimal("impact_cost"));
            tradeInfo.setPercentDeliverableTradedQuantity(rs.getBigDecimal("percent_deliverable_traded_quantity"));
            tradeInfo.setApplicableMarginRate(rs.getBigDecimal("applicable_margin_rate"));
            tradeInfo.setFaceValue(rs.getBigDecimal("face_value"));
            return tradeInfo;
        });
        return result.isEmpty() ? null : result.get(0);
    }



    // Fetch price info for a specific symbol
    public PriceInfo findPriceInfoBySymbol(String symbol) {
        String sql = "SELECT symbol, week_52_high, week_52_low, upper_band, lower_band, price_band, " +
                "daily_volatility, annualised_volatility, tick_size " +
                "FROM price_info WHERE LOWER(symbol) = LOWER(?)";

        List<PriceInfo> result = jdbcTemplate.query(sql, new Object[]{symbol}, (rs, rowNum) -> {
            PriceInfo priceInfo = new PriceInfo();
            priceInfo.setSymbol(rs.getString("symbol"));
            priceInfo.setWeek52High(rs.getBigDecimal("week_52_high"));
            priceInfo.setWeek52Low(rs.getBigDecimal("week_52_low"));
            priceInfo.setUpperBand(rs.getBigDecimal("upper_band"));
            priceInfo.setLowerBand(rs.getBigDecimal("lower_band"));
            priceInfo.setPriceBand(rs.getString("price_band"));
            priceInfo.setDailyVolatility(rs.getBigDecimal("daily_volatility"));
            priceInfo.setAnnualisedVolatility(rs.getBigDecimal("annualised_volatility"));
            priceInfo.setTickSize(rs.getBigDecimal("tick_size"));
            return priceInfo;
        });

        return result.isEmpty() ? null : result.get(0);
    }
}
