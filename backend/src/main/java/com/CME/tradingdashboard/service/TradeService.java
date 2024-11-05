package com.CME.tradingdashboard.service;

import com.CME.tradingdashboard.model.*;
import com.CME.tradingdashboard.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradingService {

    @Autowired
    private StockDataRepository stockDataRepository;

    @Autowired
    private TradeInfoRepository tradeInfoRepository;


    @Autowired
    private PriceInfoRepository priceInfoRepository;

    @Autowired
    private ClickhouseRepository clickhouseRepository;

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
        return stockDataRepository.findBySymbolIgnoreCase(symbol).orElse(null);
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



}