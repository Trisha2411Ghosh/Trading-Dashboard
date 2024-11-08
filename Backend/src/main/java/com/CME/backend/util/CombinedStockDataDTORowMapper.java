package com.CME.backend.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.CME.backend.dto.CombinedStockDataDTO;
import org.springframework.jdbc.core.RowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CombinedStockDataDTORowMapper implements RowMapper<CombinedStockDataDTO> {

    private static final Logger logger = LoggerFactory.getLogger(CombinedStockDataDTORowMapper.class);

    @Override
    public CombinedStockDataDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            CombinedStockDataDTO dto = new CombinedStockDataDTO();
            dto.setSymbol(rs.getString("s_symbol"));
            dto.setPrevClose(rs.getBigDecimal("prev_close"));
            dto.setIep(rs.getBigDecimal("iep"));
            dto.setChng(rs.getBigDecimal("chng"));
            dto.setPctChng(rs.getBigDecimal("pct_chng"));
            dto.setFinalPrice(rs.getBigDecimal("final_price"));
            dto.setFinalQuantity(rs.getBigDecimal("final_quantity"));
            dto.setValue(rs.getBigDecimal("value"));
            dto.setFfmCap(rs.getBigDecimal("ffm_cap"));
            dto.setNm52wH(rs.getBigDecimal("nm_52w_h"));
            dto.setNm52wL(rs.getBigDecimal("nm_52w_l"));
            dto.setTradedVolumeLakhs(rs.getBigDecimal("traded_volume_lakhs"));
            dto.setTradedValueCr(rs.getBigDecimal("traded_value_cr"));
            dto.setTotalMarketCapCr(rs.getBigDecimal("total_market_cap_cr"));
            dto.setFreeFloatMarketCapCr(rs.getBigDecimal("free_float_market_cap_cr"));
            dto.setImpactCost(rs.getBigDecimal("impact_cost"));
            dto.setPercentDeliverableTradedQuantity(rs.getBigDecimal("percent_deliverable_traded_quantity"));
            dto.setApplicableMarginRate(rs.getBigDecimal("applicable_margin_rate"));
            dto.setFaceValue(rs.getBigDecimal("face_value"));
            dto.setWeek52High(rs.getBigDecimal("week_52_high"));
            dto.setWeek52Low(rs.getBigDecimal("week_52_low"));
            dto.setUpperBand(rs.getBigDecimal("upper_band"));
            dto.setLowerBand(rs.getBigDecimal("lower_band"));
            dto.setPriceBand(rs.getString("price_band"));
            dto.setDailyVolatility(rs.getBigDecimal("daily_volatility"));
            dto.setAnnualisedVolatility(rs.getBigDecimal("annualised_volatility"));
            dto.setTickSize(rs.getBigDecimal("tick_size"));
            return dto;
        }
}
