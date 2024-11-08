package com.CME.backend.service;

import com.CME.backend.dto.CombinedStockDataDTO;
import com.CME.backend.model.*;
import com.CME.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradingService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private StockDataRepository stockDataRepository;

    @Autowired
    private TradeInfoRepository tradeInfoRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PriceInfoRepository priceInfoRepository;

    @Autowired
    private ClickhouseRepository clickhouseRepository;

    @Autowired
    private CombinedDataRepository combinedDataRepository;

    //fetch all stocks data
    public List<StockData> getAllStockData(String dbsource) {
        if ("clickhouse".equalsIgnoreCase(dbsource)) {
            return clickhouseRepository.findAllStockData();
        }
        return stockDataRepository.findAll();
    }

    //fetch specific stock data using symbol
    public StockData getStockDataBySymbol(String symbol, String dbsource) {
        if ("clickhouse".equalsIgnoreCase(dbsource)) {
            return clickhouseRepository.findStockDataBySymbol(symbol);
        }
        return stockDataRepository.findBySymbolIgnoreCase(symbol);
    }

    //fetch specific trade info using symbol
    public TradeInfo getTradeInfoBySymbol(String symbol, String dbsource) {
        if ("clickhouse".equalsIgnoreCase(dbsource)) {
            return clickhouseRepository.findTradeInfoBySymbol(symbol);
        }
        return tradeInfoRepository.findBySymbolIgnoreCase(symbol);

    }

    //fetch specific price info using symbol
    public PriceInfo getPriceInfoBySymbol(String symbol, String dbsource) {
        if ("clickhouse".equalsIgnoreCase(dbsource)) {
            return clickhouseRepository.findPriceInfoBySymbol(symbol);
        }
        return priceInfoRepository.findBySymbolIgnoreCase(symbol);
    }

    //fetch specific company info using symbol
    public Company getCompanyInfo(String symbol, String dbsource) {
        if ("clickhouse".equalsIgnoreCase(dbsource)) {
            List<Company> companies = clickhouseRepository.findCompanyBySymbol(symbol);
            return companies.isEmpty() ? null : companies.get(0);
        }
        return companyRepository.findBySymbolIgnoreCase(symbol).stream().findFirst().orElse(null);
    }

    //fetch combined data for a specific symbol
    public CombinedStockDataDTO getCombinedDataBySymbol(String symbol, String dbsource) {
        if ("clickhouse".equalsIgnoreCase(dbsource)) {
            return clickhouseRepository.findCombinedDataBySymbol(symbol);
        }
        return combinedDataRepository.findCombinedDataBySymbol(symbol);
    }

}