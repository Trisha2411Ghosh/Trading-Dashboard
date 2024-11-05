package com.CME.backend.controller;

import com.CME.backend.model.Company;
import com.CME.backend.model.StockData;
import com.CME.backend.model.TradeInfo;
import com.CME.backend.model.PriceInfo;
import com.CME.backend.service.TradingService;
import com.CME.backend.util.PerformanceMetrics;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class TradingController {

    @Autowired
    private TradingService tradingService;

    private PerformanceMetrics performanceMetrics = new PerformanceMetrics();
    private ObjectMapper objectMapper = new ObjectMapper();

    // Endpoint to fetch all stock data
    @GetMapping("/stocks")
    public List<StockData> getAllStockData(@RequestParam(defaultValue = "postgres") String dbsource) {
        performanceMetrics.startSession();
        List<StockData> stockData = tradingService.getAllStockData(dbsource);
        long dataSize = calculateDataSize(stockData);
        performanceMetrics.endQuery(dataSize);
        logPerformanceMetrics();
        return stockData;
    }

    // Endpoint to fetch specific stock data by symbol
    @GetMapping("/stocks/{symbol}")
    public StockData getStockData(@PathVariable String symbol,
                                  @RequestParam(defaultValue = "postgres") String dbsource) {
        performanceMetrics.startSession();
        StockData stockData = tradingService.getStockDataBySymbol(symbol, dbsource);
        long dataSize = calculateDataSize(stockData);
        performanceMetrics.endQuery(dataSize);
        logPerformanceMetrics();
        return stockData;
    }

    // Endpoint to fetch specific trade information for a symbol
    @GetMapping("/trades/{symbol}")
    public TradeInfo getTradeInfo(@PathVariable String symbol,
                                  @RequestParam(defaultValue = "postgres") String dbsource) {
        performanceMetrics.startSession();  // Start session for performance metrics
        TradeInfo tradeInfo = tradingService.getTradeInfoBySymbol(symbol, dbsource);
        long dataSize = calculateDataSize(tradeInfo);
        performanceMetrics.endQuery(dataSize);  // End query and log data size
        logPerformanceMetrics();
        return tradeInfo;
    }

    // Endpoint to fetch specific price information for a symbol
    @GetMapping("/prices/{symbol}")
    public PriceInfo getPriceInfo(@PathVariable String symbol,
                                  @RequestParam(defaultValue = "postgres") String dbsource) {
        performanceMetrics.startSession();
        PriceInfo priceInfo = tradingService.getPriceInfoBySymbol(symbol, dbsource);
        long dataSize = calculateDataSize(priceInfo);
        performanceMetrics.endQuery(dataSize);
        logPerformanceMetrics();
        return priceInfo;
    }

    // Endpoint to fetch specific price information for a symbol
    @GetMapping("/companies/{symbol}")
    public Company getCompanyInfo(@PathVariable String symbol,
                                @RequestParam(defaultValue = "postgres") String dbsource) {
        performanceMetrics.startSession();
        Company getCompanyInfo = tradingService.getCompanyInfo(symbol, dbsource);
        long dataSize = calculateDataSize(getCompanyInfo);
        performanceMetrics.endQuery(dataSize);
        logPerformanceMetrics();
        return getCompanyInfo;
    }

    // Method to calculate data size in bytes
    private long calculateDataSize(Object data) {
        try {
            return objectMapper.writeValueAsBytes(data).length;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // NOTE TO SELF - convert these log statements to key value pair for frontend
    // Method to log performance metrics and reset them
    private void logPerformanceMetrics() {
        System.out.println("Read Speed: " + performanceMetrics.getReadSpeed() + " ms");
        System.out.println("Queries Per Second: " + performanceMetrics.getQueriesPerSecond());
        System.out.println("Throughput: " + performanceMetrics.getThroughput() + " bytes/sec");
        performanceMetrics.resetMetrics();
    }
}