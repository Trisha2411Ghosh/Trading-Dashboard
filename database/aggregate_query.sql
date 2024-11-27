            SELECT
                instrument_id,
                trade_date,
                AVG(traded_value_cr) AS avg_price,
                SUM(traded_volume_lakhs) AS total_volume,
                MAX(traded_value_cr) AS max_price
            FROM
                trade_info
            WHERE
                trade_date BETWEEN ? AND ?
            GROUP BY
                instrument_id, trade_date
            ORDER BY
                trade_date ASC, instrument_id ASC
            LIMIT 100
SELECT
            industry,
            toStartOfMonth(trade_date) AS trade_month,
            AVG(traded_value_cr) AS avg_traded_value,
            SUM(traded_volume_lakhs) AS total_traded_volume,
            MAX(traded_value_cr) AS max_traded_value
        FROM
            trade_info
        INNER JOIN
            instrument USING (instrument_id)
        WHERE
            trade_date BETWEEN ? AND ?
        GROUP BY
            industry, trade_month
        ORDER BY
            trade_month ASC, industry ASC
        LIMIT 100
