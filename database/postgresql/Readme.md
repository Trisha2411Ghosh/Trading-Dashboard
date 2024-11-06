# PostgreSql Folder

This folder contains the necessary files to set up and manage the PostgreSQL database for the project. 

## Overview

The database is designed to store trading data. This document outlines the contents of the folder and instructions on how to use them.

## Contents

- `schema.sql`: Contains the SQL commands to create the `,stock_info,trade_info,price_info` table with unique symbols for each company.
- `seed.sql`:  Contains sample data to seed the `stock_info,trade_info,price_info` table for testing and development purposes.
- `ERD.png`:  Contains Entity-Relationhip Model between three models

## Database Schema

The database consists of the following tables:
### 1. `stock_data`
- **symbol**: Unique identifier for each stock record (character varying(15), PRIMARY KEY, NOT NULL).
- **prev_close**: Previous closing price of the stock (numeric(10,2)).
- **iep**: Intraday estimated price (numeric(10,2)).
- **chng**: Change in price (numeric(5,2)).
- **pct_chng**: Percentage change in price (numeric(5,2)).
- **final_value**: total value of trades for the stock at the end of the trading day..
- **final_quantity**: Quantity of stocks traded (bigint).
- **value**: Value of the stock (numeric(15,2)).
- **ffm_cap**: Free-float market capitalization (numeric(15,2)).
- **week_52_high**: Normalized 52-week high price (numeric(10,2)).
- **week_52_low**: Normalized 52-week low price (numeric(10,2)).
- **final_price**:The stock’s price at the end of the trading day (numeric(38,2)).
- **day-high**:The highest price the stock reached during the trading day (numeric(38,2)).
- **day-low:The lowest price the stock reached during the trading day (numeric(38,2)).

### 2. `price_info`
- **symbol**: Unique identifier for each company (text, PRIMARY KEY, NOT NULL).
- **week_52_high**: Normalized 52-week high price (numeric(10,2)).
- **week_52_low**: Normalized 52-week low price (numeric(10,2)).
- **upper-band**:The upper threshold for the stock's trading price range (numeric(38,2)).
- **lower-band**:The lower threshold for the stock's trading price range (numeric(38,2)).
- **price-band**: A descriptive range or category for the stock's trading price(numeric(38,2))
- **daily_volatility**: The stock's price fluctuation within a single trading day.(numeric(38,2))
- **annualised_volatility**:Projected volatility of the stock over a one-year period (numeric(38,2)).
- **tick_size**:The minimum price movement allowed for the stock (numeric(38,2)).
### 3. `trade_info`
- **id**: Unique identifier for each trade record (integer, PRIMARY KEY, NOT NULL).
- **symbol**: Unique identifier for each stock, referencing `stock_data.symbol` (character varying(15), NOT NULL).
- **traded_volume_lakhs**: Volume of stocks traded (numeric).
- **traded_value_cr**: Value of stocks traded (numeric).
- **total_market_cap_cr**: Total market capitalization (numeric).
- **ffm_cap**: Free float market capitalization (numeric).
- **impact_cost**: Impact cost (numeric).
- **percent_deliverable_traded_quantity**: Percentage of deliverable traded quantity (numeric).
- **applicable_margin_rate**: Margin rate applicable (numeric).
- **face_value**: Face value of the stock (numeric).
## Setup Instructions

1. **Create a Database**: If you haven't already, create a new PostgreSQL database for your project. You can do this using the `psql` command line or any PostgreSQL client tool like pgAdmin.

   ```sql
   CREATE DATABASE your_database_name;
  
2. **Connect to Your Database**: Open your terminal or PostgreSQL client and connect to your newly created database.

   ```bash
   psql -U your_username -d your_database_name


3. **Run the Schema Script**: Execute the `schema.sql` script to create the necessary tables.

   ```sql
   \i path/to/schema.sql
## Seed Data

**Seed the Database**: The `seed.sql` script contains sample data to populate the tables for testing and development purposes. This can help you verify that your database is functioning correctly.

### Usage

To execute the `seed.sql` script, run the following command after connecting to your database:

```sql
\i path/to/seed.sql


