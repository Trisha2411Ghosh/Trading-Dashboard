package com.CME.tradingdashboard;

import com.CME.tradingdashboard.model.*;
import com.CME.tradingdashboard.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradingdashboardApplication {

	@Autowired
	private StockDataRepository stockDataRepo;

	@Autowired
	private TradeInfoRepository tradeInfoRepo;


	@Autowired
	private PriceInfoRepository priceInfoRepo;

	@Autowired
	private ClickhouseRepository clickhouseRepo;

	public List<StockData> fetchAllStockData(String dataSource) {
		if ("clickhouse".equalsIgnoreCase(dataSource)) {
			return clickhouseRepo.findAllStockData();
		}
		return stockDataRepo.findAll();
	}

	public StockData fetchStockDataBySymbol(String symbol, String dataSource) {
		if ("clickhouse".equalsIgnoreCase(dataSource)) {
			return clickhouseRepo.findStockDataBySymbol(symbol);
		}
		return stockDataRepo.findBySymbolIgnoreCase(symbol).orElse(null);
	}

	public TradeInfo fetchTradeInfoBySymbol(String symbol, String dataSource) {
		if ("clickhouse".equalsIgnoreCase(dataSource)) {
			return clickhouseRepo.findTradeInfoBySymbol(symbol);
		}
		return tradeInfoRepo.findBySymbolIgnoreCase(symbol);
	}



	public PriceInfo fetchPriceInfoBySymbol(String symbol, String dataSource) {
		if ("clickhouse".equalsIgnoreCase(dataSource)) {
			return clickhouseRepo.findPriceInfoBySymbol(symbol);
		}
		return priceInfoRepo.findBySymbolIgnoreCase(symbol);
	}
}
