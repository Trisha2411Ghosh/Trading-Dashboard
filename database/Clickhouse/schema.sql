CREATE TABLE IF NOT EXISTS stock_data (
   symbol character varying(255) COLLATE pg_catalog."default" NOT NULL,
    prev_close numeric(38,2),
    iep numeric(38,2),
    chng numeric(38,2),
    pct_chng numeric(38,2),
    final_value numeric(10,2),
    final_quantity integer,
    value numeric(38,2),
    ffm_cap numeric(38,2),
    week_52_high numeric(10,2),
    week_52_low numeric(10,2),
    final_price numeric(38,2),
    day_high numeric(38,2),
    day_low numeric(38,2),
    CONSTRAINT symbol PRIMARY KEY (symbol)
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
