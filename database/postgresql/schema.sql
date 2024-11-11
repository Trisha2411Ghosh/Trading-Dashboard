-- Table: public.stock_data
CREATE TABLE IF NOT EXISTS public.stock_data
(
    symbol character varying(255) COLLATE pg_catalog."default" NOT NULL,
    prev_close numeric(38,2),
    iep numeric(38,2),
    chng numeric(38,2),
    pct_chng numeric(38,2),
    final_value numeric(38,2),
    final_quantity integer,
    value numeric(38,2),
    ffm_cap numeric(38,2),
    week_52_high numeric(38,2),
    week_52_low numeric(38,2),
    final_price numeric(38,2),
    day_high numeric(38,2),
    day_low numeric(38,2),
    CONSTRAINT symbol PRIMARY KEY (symbol)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.stock_data
    OWNER to postgres;


--create trade_info table
CREATE TABLE IF NOT EXISTS public.trade_info
(
    trade_id character varying(6) COLLATE pg_catalog."default" NOT NULL DEFAULT generate_trade_id(),
    instrument_id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    traded_volume_lakhs numeric(38,2),
    traded_value_cr numeric(38,2),
    total_market_cap_cr numeric(38,2),
    ffm_cap numeric(38,2),
    impact_cost numeric(38,2),
    percent_deliverable_traded_quantity numeric(38,2),
    applicable_margin_rate numeric(38,2),
    face_value numeric(38,2),
    CONSTRAINT trade_info_pkey1 PRIMARY KEY (trade_id),
    CONSTRAINT fk_instrument_id FOREIGN KEY (instrument_id)
        REFERENCES public.instrument (instrument_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.trade_info
    OWNER to postgres;


-- Table: public.instrument

CREATE TABLE IF NOT EXISTS public.instrument
(
    instrument_id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    week_52_high numeric(10,2),
    week_52_low numeric(10,2),
    upper_band numeric(38,2),
    lower_band numeric(38,2),
    price_band character varying(255) COLLATE pg_catalog."default",
    daily_volatility numeric(38,2),
    annualised_volatility numeric(38,2),
    tick_size numeric(38,2),
    long_name character varying(255) COLLATE pg_catalog."default",
    industry character varying(255) COLLATE pg_catalog."default",
    stock_exchange character varying COLLATE pg_catalog."default",
    pe_ratio numeric(10,2),
    dividend_yield numeric(5,2),
    roe numeric(5,2),
    CONSTRAINT instrument_pkey PRIMARY KEY (instrument_id),
    CONSTRAINT symbol_fk FOREIGN KEY (instrument_id)
        REFERENCES public.stock_data (symbol) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.instrument
    OWNER to postgres;
