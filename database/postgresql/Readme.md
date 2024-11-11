# PostgreSql Database Setup

This guide contains the necessary files to set up and manage the PostgreSQL database for the project. 

## Overview

The database is designed to store trading data. This document outlines the contents of the folder and instructions on how to use them.

## Contents

- `schema.sql`: Contains the SQL commands to create the `,stock_info,trade_info,price_info` table with unique symbols for each company.
- `seed.sql`:  Contains sample data to seed the `stock_info,trade_info,price_info` table for testing and development purposes.
- `ERD.png`:  Contains Entity-Relationhip Model between three models

## Database Schema

The database consists of the following tables:
### 1. `stock_data` Table Schema

This table stores real-time and historical data about stock performance, including trading prices, volumes, and other financial metrics.

| Column Name             | Data Type                | Description                                                         |
|-------------------------|--------------------------|---------------------------------------------------------------------|
| `symbol`                | `VARCHAR(15)`            | Unique identifier for each stock record (Primary Key, NOT NULL)     |
| `prev_close`            | `NUMERIC(10,2)`          | Previous closing price of the stock                                 |
| `iep`                   | `NUMERIC(10,2)`          | Intraday estimated price                                            |
| `chng`                  | `NUMERIC(5,2)`           | Change in price                                                     |
| `pct_chng`              | `NUMERIC(5,2)`           | Percentage change in price                                          |
| `final_value`           | `NUMERIC(15,2)`          | Total value of trades for the stock at the end of the trading day   |
| `final_quantity`        | `BIGINT`                 | Quantity of stocks traded                                           |
| `value`                 | `NUMERIC(15,2)`          | Value of the stock                                                  |
| `ffm_cap`               | `NUMERIC(15,2)`          | Free-float market capitalization                                    |
| `week_52_high`          | `NUMERIC(10,2)`          | Normalized 52-week high price                                       |
| `week_52_low`           | `NUMERIC(10,2)`          | Normalized 52-week low price                                        |
| `final_price`           | `NUMERIC(38,2)`          | The stock’s price at the end of the trading day                     |
| `day_high`              | `NUMERIC(38,2)`          | The highest price the stock reached during the trading day          |
| `day_low`               | `NUMERIC(38,2)`          | The lowest price the stock reached during the trading day           |

#### Constraints:
- **Primary Key**: `symbol`

#### Table Ownership:
- Owned by the `postgres` user.

### 2`instruments` Table Schema

This table stores detailed information about stock instruments, including key financial metrics, price range details, and additional information about the company.

| Column Name              | Data Type                | Description                                                        |
|------------------------- |--------------------------|--------------------------------------------------------------------|
| `instrument_id`          | `VARCHAR(255)`           | Unique identifier for each instrument (Primary Key, NOT NULL)      |
| `week_52_high`           | `NUMERIC(10,2)`          | Normalized 52-week high price                                      |
| `week_52_low`            | `NUMERIC(10,2)`          | Normalized 52-week low price                                       |
| `upper_band`             | `NUMERIC(38,2)`          | Upper threshold for the stock's trading price range                |
| `lower_band`             | `NUMERIC(38,2)`          | Lower threshold for the stock's trading price range                |
| `price_band`             | `VARCHAR(255)`           | Descriptive range or category for the stock's trading price        |
| `daily_volatility`       | `NUMERIC(38,2)`          | Stock's price fluctuation within a single trading day              |
| `annualised_volatility`  | `NUMERIC(38,2)`          | Projected volatility of the stock over a one-year period           |
| `tick_size`              | `NUMERIC(38,2)`          | Minimum price movement allowed for the stock                       |
| `long_name`              | `VARCHAR(255)`           | Full company name                                                  |
| `industry`               | `VARCHAR(255)`           | Industry category for the instrument                               |
| `stock_exchange`         | `VARCHAR(255)`           | The stock exchange where the instrument is listed                  |
| `pe_ratio`               | `NUMERIC(10,2)`          | Price-to-Earnings ratio for the instrument                         |
| `dividend_yield`         | `NUMERIC(5,2)`           | Dividend yield of the stock                                        |
| `roe`                    | `NUMERIC(5,2)`           | Return on equity ratio for the instrument                          |

#### Constraints:
- **Primary Key**: `instrument_id`
- **Foreign Key**: `instrument_id` references `symbol` in `public.stock_data` table

#### Table Ownership:
- Owned by the `postgres` user.

### 3. `trade_info` Table Schema
This table holds details about trades, including volume, value, market capitalization, and other trade-related metrics associated with each instrument.

| Column Name                             | Data Type                | Description                                         |
|-----------------------------------------|--------------------------|-----------------------------------------------------|
| `trade_id`                              | `VARCHAR(6)`             | Unique identifier for each trade record (PrimayKey, |
|                                         |                          | NOT NULL, Default: `generate_trade_id()`)           |
| `instrument_id`                         | `VARCHAR(255)`           | Identifier linking the trade to an instrument       |
|                                         |                          | (Foreign Key, NOT NULL)                             |
| `traded_volume_lakhs`                   | `NUMERIC(38,2)`          | Volume of the trade in lakhs                        |
| `traded_value_cr`                       | `NUMERIC(38,2)`          | Value of the trade in crores                        |
| `total_market_cap_cr`                   | `NUMERIC(38,2)`          | Total market capitalization of the traded           |
|                                         |                          | instrument in crores                                |
| `ffm_cap`                               | `NUMERIC(38,2)`          | Free-float market capitalization of the traded      |
|                                         |                          | instrument                                          |
| `impact_cost`                           | `NUMERIC(38,2)`          | Cost impact of the trade on the market price        |
| `percent_deliverable_traded_quantity`   | `NUMERIC(38,2)`          | Percentage of the traded quantity that is           |
|                                         |                          | deliverable                                         |
| `applicable_margin_rate`                | `NUMERIC(38,2)`          | Margin rate applicable to the trade                 |
| `face_value`                            | `NUMERIC(38,2)`          | Face value of the traded instrument                 |

#### Constraints:
- **Primary Key**: `trade_id`
- **Foreign Key**: `instrument_id` references `instrument(instrument_id)`

#### Table Ownership:
- Owned by the `postgres` user.
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


