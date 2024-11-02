package com.CME.tradingdashboard.repository;

import com.CME.tradingdashboard.model.TradeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeInfoRepository extends JpaRepository<TradeInfo, Integer> {
    List<TradeInfo> findBySymbolIgnoreCase(String symbol);
}
