package com.CME.backend.repository;

import com.CME.backend.model.instrument;
import com.CME.backend.model.TradeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeInfoRepository extends JpaRepository<TradeInfo, Integer> {
    TradeInfo findBytrade_idIgnoreCase(String trade_id);
}

