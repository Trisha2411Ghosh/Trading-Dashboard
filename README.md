# Trading Dashboard Backend

## Overview

The **Trading Dashboard** backend provides RESTful APIs to query stock, trade, and instrument data from PostgreSQL and ClickHouse databases. It allows users to compare the read performance (speed and throughput) of both databases.

## Features

- **Performance Metrics Comparison**: Measure and compare read speeds and throughput between PostgreSQL and ClickHouse.
- **Data Access**: Query stock data, trade info, and instrument details.
- **Combined Data**: Fetch combined data for a specific symbol from multiple tables.

## Endpoints

### 1. **/stocks**

- **GET**: Fetch all stock data.
- **Query Params**: `dbsource` (`postgres` or `clickhouse`).
- **Response**: List of stock data.

### 2. **/stocks/{symbol}**

- **GET**: Fetch stock data for a specific symbol.
- **Path Params**: `symbol` (e.g., "AAPL").
- **Query Params**: `dbsource` (`postgres` or `clickhouse`).
- **Response**: Stock data for the symbol.

### 3. **/trades/{symbol}**

- **GET**: Fetch trade information for a specific symbol.
- **Path Params**: `symbol` (e.g., "AAPL").
- **Query Params**: `dbsource` (`postgres` or `clickhouse`).
- **Response**: List of trade information.

### 4. **/instruments/{instrumentId}**

- **GET**: Fetch instrument details for a specific instrument ID.
- **Path Params**: `instrumentId` (e.g., "12345").
- **Query Params**: `dbsource` (`postgres` or `clickhouse`).
- **Response**: Instrument details.

### 5. **/combined/{symbol}**

- **GET**: Fetch combined data for a symbol (stock, trade, and instrument data).
- **Path Params**: `symbol` (e.g., "AAPL").
- **Query Params**: `dbsource` (`postgres` or `clickhouse`).
- **Response**: Combined data for the symbol.

## Performance Metrics

Each endpoint returns performance metrics in the response, including:

- **Read Speed**: Time taken to execute the query.
- **Throughput**: Data read per second.

Example response:

```json
{
  "data": [/* ... */],
  "performanceMetrics": {
    "readSpeed": "50 ms",
    "throughput": "1024 bytes/sec"
  }
}
