CREATE TABLE IF NOT EXISTS stock_data (
    symbol String,
    prev_close Decimal(10, 2),
    iep Decimal(10, 2),
    chng Decimal(5, 2),
    pct_chng Decimal(5, 2),
    final Decimal(10, 2),
    final_quantity UInt64,
    value Decimal(15, 2),
    ffm_cap Decimal(15, 2),
    nm_52w_h Decimal(10, 2),
    nm_52w_l Decimal(10, 2)
) ENGINE = MergeTree() 
ORDER BY symbol;

CREATE TABLE IF NOT EXISTS trade_info (
    symbol String,
    traded_volume_lakhs Decimal(10, 2),
    traded_value_cr Decimal(10, 2),
    total_market_cap_cr Decimal(10, 2),
    free_float_market_cap_cr Decimal(10, 2),
    impact_cost Decimal(10, 2),
    percent_deliverable_traded_quantity Decimal(10, 2),
    applicable_margin_rate Decimal(10, 2),
    face_value Decimal(10, 2)
) ENGINE = MergeTree() 
ORDER BY symbol;

CREATE TABLE IF NOT EXISTS price_info (
    symbol String,
    week_52_high Decimal(10, 2),
    week_52_low Decimal(10, 2),
    upper_band Decimal(10, 2),
    lower_band Decimal(10, 2),
    price_band String,
    daily_volatility Decimal(5, 2),
    annualised_volatility Decimal(5, 2),
    tick_size Decimal(5, 2)
) ENGINE = MergeTree() 
ORDER BY symbol;
