package com.CME.backend.repository;

import com.CME.backend.dto.CombinedStockDataDTO;
import com.CME.backend.model.StockData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CombinedDataRepository extends JpaRepository<StockData, String> {

    @Query("""
    SELECT new com.CME.backend.dto.CombinedStockDataDTO(
        s.symbol, s.prevClose, s.iep, s.chng, s.pctChng, s.finalPrice,
        s.finalQuantity, s.value, s.ffmCap, s.nm52wH, s.nm52wL,
        t.tradedVolumeLakhs, t.tradedValueCr, t.totalMarketCapCr,
        t.freeFloatMarketCapCr, t.impactCost, t.percentDeliverableTradedQuantity,
        t.applicableMarginRate, t.faceValue,
        p.week52High, p.week52Low, p.upperBand, p.lowerBand, 
        p.priceBand, p.dailyVolatility, p.annualisedVolatility, p.tickSize
    )
    FROM StockData s
    LEFT JOIN TradeInfo t ON s.symbol = t.symbol
    LEFT JOIN PriceInfo p ON s.symbol = p.symbol
    WHERE LOWER(s.symbol) = LOWER(:symbol)
""")
    CombinedStockDataDTO findCombinedDataBySymbol(@Param("symbol") String symbol);

}
