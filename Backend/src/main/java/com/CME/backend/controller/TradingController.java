package com.CME.backend.controller;

import com.CME.backend.dto.CombinedStockDataDTO;
import com.CME.backend.model.*;
import com.CME.backend.service.TradingService;
import com.CME.backend.util.PerformanceMetrics;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Map<String, Object>> getAllStockData(@RequestParam(defaultValue = "postgres") String dbsource) {
        performanceMetrics.startSession();
        List<StockData> stockData = tradingService.getAllStockData(dbsource);
        long dataSize = calculateDataSize(stockData);
        performanceMetrics.endQuery(dataSize);

        // Prepare response with data and performance metrics
        Map<String, Object> response = new HashMap<>();
        response.put("data", stockData);
        response.put("performanceMetrics", getPerformanceMetrics());

        return ResponseEntity.ok(response);
    }

    // Endpoint to fetch specific stock data by symbol
    @GetMapping("/stocks/{symbol}")
    public ResponseEntity<Map<String, Object>> getStockData(@PathVariable String symbol,
                                                            @RequestParam(defaultValue = "postgres") String dbsource) {
        performanceMetrics.startSession();
        StockData stockData = tradingService.getStockDataBySymbol(symbol, dbsource);
        long dataSize = calculateDataSize(stockData);
        performanceMetrics.endQuery(dataSize);

        // Prepare response with data and performance metrics
        Map<String, Object> response = new HashMap<>();
        response.put("data", stockData);
        response.put("performanceMetrics", getPerformanceMetrics());

        return ResponseEntity.ok(response);
    }

    // Endpoint to fetch specific trade information for a symbol
    @GetMapping("/trades/{symbol}")
    public ResponseEntity<Map<String, Object>> getTradeInfo(@PathVariable String symbol,
                                                            @RequestParam(defaultValue = "postgres") String dbsource) {
        performanceMetrics.startSession();
        TradeInfo tradeInfo = tradingService.getTradeInfoBySymbol(symbol, dbsource);
        long dataSize = calculateDataSize(tradeInfo);
        performanceMetrics.endQuery(dataSize);

        // Prepare response with data and performance metrics
        Map<String, Object> response = new HashMap<>();
        response.put("data", tradeInfo);
        response.put("performanceMetrics", getPerformanceMetrics());

        return ResponseEntity.ok(response);
    }

    // Endpoint to fetch specific price information for a symbol
    @GetMapping("/prices/{symbol}")
    public ResponseEntity<Map<String, Object>> getPriceInfo(@PathVariable String symbol,
                                                            @RequestParam(defaultValue = "postgres") String dbsource) {
        performanceMetrics.startSession();
        PriceInfo priceInfo = tradingService.getPriceInfoBySymbol(symbol, dbsource);
        long dataSize = calculateDataSize(priceInfo);
        performanceMetrics.endQuery(dataSize);

        // Prepare response with data and performance metrics
        Map<String, Object> response = new HashMap<>();
        response.put("data", priceInfo);
        response.put("performanceMetrics", getPerformanceMetrics());

        return ResponseEntity.ok(response);
    }

    // Endpoint to fetch specific company information for a symbol
    @GetMapping("/companies/{symbol}")
    public ResponseEntity<Map<String, Object>> getCompanyInfo(@PathVariable String symbol,
                                                              @RequestParam(defaultValue = "postgres") String dbsource) {
        performanceMetrics.startSession();
        Company companyInfo = tradingService.getCompanyInfo(symbol, dbsource);
        long dataSize = calculateDataSize(companyInfo);
        performanceMetrics.endQuery(dataSize);

        // Prepare response with data and performance metrics
        Map<String, Object> response = new HashMap<>();
        response.put("data", companyInfo);
        response.put("performanceMetrics", getPerformanceMetrics());

        return ResponseEntity.ok(response);
    }

    // Endpoint to fetch combined data for a symbol
    @GetMapping("/combined/{symbol}")
    public ResponseEntity<Map<String, Object>> getCombinedData(
            @PathVariable String symbol,
            @RequestParam(defaultValue = "postgres") String dbsource) {
        performanceMetrics.startSession();
        CombinedStockDataDTO combinedData = tradingService.getCombinedDataBySymbol(symbol, dbsource);
        long dataSize = calculateDataSize(combinedData);
        performanceMetrics.endQuery(dataSize);

        // Prepare response with data and performance metrics
        Map<String, Object> response = new HashMap<>();
        response.put("data", combinedData);
        response.put("performanceMetrics", getPerformanceMetrics());

        return ResponseEntity.ok(response);
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

    // Method to get performance metrics as a map and reset them
    private Map<String, Object> getPerformanceMetrics() {
        Map<String, Object> metrics = new HashMap<>();
        metrics.put("readSpeed", performanceMetrics.getReadSpeed() + " ms");
        metrics.put("throughput", performanceMetrics.getThroughput() + " bytes/sec");
        performanceMetrics.resetMetrics();
        return metrics;
    }
}
