package com.CME.backend.repository;

import com.CME.backend.model.Company;
import com.CME.backend.model.PriceInfo;
import com.CME.backend.model.StockData;
import com.CME.backend.model.TradeInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class ClickhouseRepository {
    private final JdbcTemplate jdbcTemplate;

    public ClickhouseRepository(@Qualifier("clickhouseJdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Fetch all stocks data from stock_data table
    public List<StockData> findAllStockData() {
        String sql = "SELECT symbol, prev_close, iep, chng, pct_chng, final, final_quantity, value, ffm_cap, nm_52w_h, nm_52w_l FROM stock_data";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            StockData stockData = new StockData();
            stockData.setSymbol(rs.getString("symbol"));
            stockData.setPrevClose(rs.getBigDecimal("prev_close"));
            stockData.setIep(rs.getBigDecimal("iep"));
            stockData.setChng(rs.getBigDecimal("chng"));
            stockData.setPctChng(rs.getBigDecimal("pct_chng"));
            stockData.setFinalPrice(rs.getBigDecimal("final"));
            stockData.setFinalQuantity(rs.getInt("final_quantity"));
            stockData.setValue(rs.getBigDecimal("value"));
            stockData.setFfmCap(rs.getBigDecimal("ffm_cap"));
            stockData.setNm52wH(rs.getBigDecimal("nm_52w_h"));
            stockData.setNm52wL(rs.getBigDecimal("nm_52w_l"));
            return stockData;
        });
    }

//    fetch data of a specific stock from stock_data using symbol
    public StockData findStockDataBySymbol(String symbol) {
        String sql = "SELECT symbol, prev_close, iep, chng, pct_chng, final, final_quantity, value, ffm_cap, nm_52w_h, nm_52w_l FROM stock_data WHERE LOWER(symbol) = LOWER(?)";
        List<StockData> result = jdbcTemplate.query(sql, new Object[]{symbol}, (rs, rowNum) -> {
            StockData stockData = new StockData();
            stockData.setSymbol(rs.getString("symbol"));
            stockData.setPrevClose(rs.getBigDecimal("prev_close"));
            stockData.setIep(rs.getBigDecimal("iep"));
            stockData.setChng(rs.getBigDecimal("chng"));
            stockData.setPctChng(rs.getBigDecimal("pct_chng"));
            stockData.setFinalPrice(rs.getBigDecimal("final"));
            stockData.setFinalQuantity(rs.getInt("final_quantity"));
            stockData.setValue(rs.getBigDecimal("value"));
            stockData.setFfmCap(rs.getBigDecimal("ffm_cap"));
            stockData.setNm52wH(rs.getBigDecimal("nm_52w_h"));
            stockData.setNm52wL(rs.getBigDecimal("nm_52w_l"));
            return stockData;
        });
        return result.isEmpty() ? null : result.get(0);
    }

    //    fetch data of a specific trade from trade_info using symbol
    public TradeInfo findTradeInfoBySymbol(String symbol) {
        String sql = "SELECT * FROM trade_info WHERE LOWER(symbol) = LOWER(?)";
        List<TradeInfo>result =  jdbcTemplate.query(sql, new Object[]{symbol}, (rs, rowNum) -> {
            TradeInfo tradeInfo = new TradeInfo();
            tradeInfo.setId(rs.getInt("id"));
            tradeInfo.setSymbol(rs.getString("symbol"));
            tradeInfo.setTradedVolumeLakhs(rs.getBigDecimal("traded_volume_lakhs"));
            tradeInfo.setTradedValueCr(rs.getBigDecimal("traded_value_cr"));
            tradeInfo.setTotalMarketCapCr(rs.getBigDecimal("total_market_cap_cr"));
            tradeInfo.setFreeFloatMarketCapCr(rs.getBigDecimal("free_float_market_cap_cr"));
            tradeInfo.setImpactCost(rs.getBigDecimal("impact_cost"));
            tradeInfo.setPercentDeliverableTradedQuantity(rs.getBigDecimal("percent_deliverable_traded_quantity"));
            tradeInfo.setApplicableMarginRate(rs.getBigDecimal("applicable_margin_rate"));
            tradeInfo.setFaceValue(rs.getBigDecimal("face_value"));
            return tradeInfo;
        });
        return result.isEmpty() ? null : result.get(0);
    }

    //    fetch data of a specific price from price_info using symbol
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

    // Fetch company details for a specific symbol from companies
    public List<Company> findCompanyBySymbol(String symbol) {
        String sql = "SELECT symbol, name, sector, industry FROM companies WHERE LOWER(symbol) = LOWER(?)";
        return jdbcTemplate.query(sql, new Object[]{symbol}, (rs, rowNum) -> {
            Company company = new Company();
            company.setSymbol(rs.getString("symbol"));
            company.setName(rs.getString("name"));
            company.setSector(rs.getString("sector"));
            company.setIndustry(rs.getString("industry"));
            return company;
        });
    }

}
