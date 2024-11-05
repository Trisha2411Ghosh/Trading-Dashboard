package com.CME.backend.repository;

import com.CME.backend.model.PriceInfo;
import com.CME.backend.model.TradeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeInfoRepository extends JpaRepository<TradeInfo, Integer> {
    TradeInfo findBySymbolIgnoreCase(String symbol);
}

