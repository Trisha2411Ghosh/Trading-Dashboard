package com.CME.backend.repository;

import com.CME.backend.model.PriceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceInfoRepository extends JpaRepository<PriceInfo, String> {
    PriceInfo findBySymbolIgnoreCase(String symbol);
}