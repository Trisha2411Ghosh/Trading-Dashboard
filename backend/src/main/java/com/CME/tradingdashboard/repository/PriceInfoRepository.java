package com.CME.tradingdashboard.repository;

import com.CME.tradingdashboard.model.PriceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceInfoRepository extends JpaRepository<PriceInfo, String> {
    PriceInfo findBySymbolIgnoreCase(String symbol);
}
