package com.CME.backend.repository;

import com.CME.backend.model.StockData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StockDataRepository extends JpaRepository<StockData, String> {
    Optional<StockData> findBySymbolIgnoreCase(String symbol);
}
