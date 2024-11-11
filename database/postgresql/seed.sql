DO $$
DECLARE
    stock_symbol TEXT;
    random_value NUMERIC;
    random_change NUMERIC;
BEGIN
    FOR stock_symbol IN SELECT symbols FROM temp_symbols LOOP
        random_value := ROUND((100 + random() * 900)::NUMERIC, 2);
        random_change := ROUND((random() * 100 - 50)::NUMERIC, 2);

        INSERT INTO stock_data (
            SYMBOL,
            PREV_CLOSE,
            IEP,
            CHNG,
            PCT_CHNG,
            FINAL_VALUE,
            FINAL_QUANTITY,
            VALUE,
            FFM_CAP,
            WEEK_52_HIGH,
            WEEK_52_LOW,
            FINAL_PRICE,
            DAY_HIGH,
            DAY_LOW
        ) VALUES (
            stock_symbol,
            random_value,
            random_value + random_change,
            random_change,
            ROUND((random_change / random_value) * 100, 2),
            random_value + random_change,
            (random() * 999000 + 1000)::BIGINT,
            ROUND((random() * 100)::NUMERIC, 2),
            ROUND((10 + random() * 990)::NUMERIC, 2),
            ROUND((500 + random() * 1500)::NUMERIC, 2),
            ROUND((100 + random() * 400)::NUMERIC, 2)
            ROUND((10 + random() * 990)::NUMERIC, 2),  
            ROUND((500 + random() * 1500)::NUMERIC, 2),  
            ROUND((100 + random() * 400)::NUMERIC, 2)   
        );
    END LOOP;
END $$;
--trade_info--
DO $$
DECLARE
    record RECORD;
BEGIN
    FOR record IN SELECT symbol, ffm_cap FROM public.stock_data LOOP
        INSERT INTO public.trade_info (
            trade_id
            instrument_id,
            traded_volume_lakhs,
            traded_value_cr,
            total_market_cap_cr,
            ffm_cap,
            impact_cost,
            percent_deliverable_traded_quantity,
            applicable_margin_rate,
            face_value
        )
        VALUES (
            generate_trade_id()
            record.symbol,
            ROUND((1 + (random() * 100))::numeric, 2),
            ROUND((10 + (random() * 500))::numeric, 2),
            ROUND(record.ffm_cap * (1 + ((random() - 0.5) * 0.1))::numeric, 2),
            record.ffm_cap,
            ROUND((random() * 0.1)::numeric, 4),
            ROUND((30 + (random() * 70))::numeric, 2),
            ROUND((5 + (random() * 15))::numeric, 2),
            ROUND((1 + (random() * 100))::numeric, 2)
        );
    END LOOP;
END $$;

-- Insert data into the instrument table
DO $$
DECLARE
    stock_record RECORD;
    info_record  RECORD;
BEGIN
   FOR stock_record IN 
        SELECT symbol, week_52_high, week_52_low 
        FROM public.stock_data
    LOOP
        -- Fetch the corresponding data from instrument_info for the current symbol
        SELECT long_name, industry, stock_exchange
        INTO info_record
        FROM public.instrument_info
        WHERE instrument_info_id = stock_record.symbol;
        INSERT INTO public.instrument (
            instrument,
            week_52_high,
            week_52_low,
            upper_band,
            lower_band,
            price_band,
            daily_volatility,
            annualised_volatility,
            tick_size,
            long_name,
            industry,
            stock_exchange,
            pe_ratio,
            dividend_yield,
            roe
        ) VALUES (
            stock_record.symbol,
            stock_record.week_52_high,
            stock_record.week_52_low,
            ROUND((stock_record.week_52_high + random() * 10) :: NUMERIC, 2),  -- Random upper_band based on week_52_high
            ROUND((stock_record.week_52_low + random() * 10) :: NUMERIC, 2),  -- Random lower_band based on week_52_low
            'No Band',  
            ROUND((1 + random() * 5) :: NUMERIC, 2),  -- Random daily volatility between 1 and 5
            ROUND((10 + random() * 25) :: NUMERIC, 2),  -- Random annualised volatility between 10 and 35
            ROUND((0.05 + random() * 0.15) :: NUMERIC, 2),-- Random tick size between 0.05 and 0.2
            info_record.long_name,
            info_record.industry,
            info_record.stock_exchange,
            ROUND((random() * (50 - 5) + 5)::numeric, 2);
            ROUND((random() * 10)::numeric, 2);
            ROUND((random() * (25 - 5) + 5)::numeric, 2);
            
        );
    END LOOP;
END $$;

