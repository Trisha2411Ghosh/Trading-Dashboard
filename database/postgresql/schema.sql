-- Table: public.tock_data
CREATE TABLE IF NOT EXISTS public.stock_data
(
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
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.stock_data
    OWNER to postgres;


--create trade_info table
CREATE TABLE IF NOT EXISTS public.trade_info
(
    symbol character varying(15) COLLATE pg_catalog."default" NOT NULL,
    traded_volume_lakhs numeric,
    traded_value_cr numeric,
    total_market_cap_cr numeric,
    ffm_cap numeric,
    impact_cost numeric,
    percent_deliverable_traded_quantity numeric,
    applicable_margin_rate numeric,
    face_value numeric,
    CONSTRAINT trade_info_pkey PRIMARY KEY (symbol),
    CONSTRAINT fk_symbol FOREIGN KEY (symbol)
        REFERENCES public.stock_data (symbol) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.trade_info
    OWNER to postgres;


-- Table: public.price_info

CREATE TABLE IF NOT EXISTS public.price_info
(
    symbol character varying(15) COLLATE pg_catalog."default" NOT NULL,
    week_52_high numeric(10,2),
    week_52_low numeric(10,2),
    upper_band numeric(10,2),
    lower_band numeric(10,2),
    price_band character varying(20) COLLATE pg_catalog."default",
    daily_volatility numeric(5,2),
    annualised_volatility numeric(5,2),
    tick_size numeric(5,2),
    CONSTRAINT price_info_pkey PRIMARY KEY (symbol),
    CONSTRAINT symbol_fk FOREIGN KEY (symbol)
        REFERENCES public.stock_data (symbol) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.price_info
    OWNER to postgres;

-- CREATE TABLE IF NOT EXISTS public.companies
-- (
--     symbol text COLLATE pg_catalog."default" NOT NULL,
--     name text COLLATE pg_catalog."default" NOT NULL,
--     sector text COLLATE pg_catalog."default",
--     industry text COLLATE pg_catalog."default",
--     CONSTRAINT companies_pkey PRIMARY KEY (symbol),
--     CONSTRAINT companies_symbol_key UNIQUE (symbol),
--     CONSTRAINT symbol FOREIGN KEY (symbol)
--         REFERENCES public.stock_data (symbol) MATCH SIMPLE
--         ON UPDATE NO ACTION
--         ON DELETE CASCADE
--         NOT VALID
-- );


--TABLESPACE pg_default;

--ALTER TABLE IF EXISTS public.companies
    --OWNER to postgres;
