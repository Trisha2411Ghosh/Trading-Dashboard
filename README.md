# **Trading Dashboard Backend**

## **Overview**
The **Trading Dashboard** backend is a RESTful API service that provides access to stock, trade, and instrument data from PostgreSQL and ClickHouse databases.
It enables users to query financial data efficiently and compare the read performance (speed and throughput) of both databases.  

This project is deployed using [Render](https://render.com) and can be accessed at:  
 - **[https://trading-dashboard-backend.onrender.com/](https://trading-dashboard-backend.onrender.com/)**  

---

## **Features**
- **Database Comparison**: Compare read speeds and throughput between PostgreSQL and ClickHouse databases.
- **Comprehensive Data Access**: Query data from stock, trade, and instrument tables.
- **Combined Data Retrieval**: Retrieve aggregated information for specific symbols across multiple tables.
- **Aggregate Statistics**: Fetch trade specific and industry specific aggregate statistics for a given date range.
- **Deployed Service**: Available via a public Render deployment for easy access and integration.

---

## **Endpoints**

### **1. `/stocks`**
- **Method**: `GET`  
- **Description**: Fetch all stock data.  
- **Query Params**:  
  - `dbsource` (`postgres` or `clickhouse`)  
- **Response**: List of stock data.  

---

### **2. `/stocks/{symbol}`**
- **Method**: `GET`  
- **Description**: Fetch stock data for a specific symbol.  
- **Path Params**:  
  - `symbol` (e.g., "AAPL")  
- **Query Params**:  
  - `dbsource` (`postgres` or `clickhouse`)  
- **Response**: Stock data for the specified symbol.  

---

### **3. `/trades/{instrumentid}`**
- **Method**: `GET`  
- **Description**: Fetch trade information for a specific instrument ID.  
- **Path Params**:  
  - `instrumentid` (e.g., "AAPL")  
- **Query Params**:  
  - `dbsource` (`postgres` or `clickhouse`)  
- **Response**: List of trade information.  

---

### **4. `/instruments/{instrumentId}`**
- **Method**: `GET`  
- **Description**: Fetch instrument details for a specific instrument ID.  
- **Path Params**:  
  - `instrumentId` (e.g., "AAPL")  
- **Query Params**:  
  - `dbsource` (`postgres` or `clickhouse`)  
- **Response**: Details of the specified instrument.  

---

### **5. `/combined/{symbol}`**
- **Method**: `GET`  
- **Description**: Fetch combined data for a symbol (stock, trade, and instrument data).  
- **Path Params**:  
  - `symbol` (e.g., "AAPL")  
- **Query Params**:  
  - `dbsource` (`postgres` or `clickhouse`)  
- **Response**: Combined data for the specified symbol.  

---

### **6. `/aggregate`**
- **Method**: `GET`  
- **Description**: Fetch trade specific aggregate statistics for a specified date range.  
- **Query Params**:  
  - `dbsource` (`postgres` or `clickhouse`)  
  - `startDate` (e.g., "2024-01-01")  
  - `endDate` (e.g., "2024-01-31")  
- **Response**: Trade-level aggregate statistics.  

---

### **7. `/industry`**
- **Method**: `GET`  
- **Description**: Fetch industry specific aggregate statistics for a specified date range.  
- **Query Params**:  
  - `dbsource` (`postgres` or `clickhouse`)  
  - `startDate` (e.g., "2024-01-01")  
  - `endDate` (e.g., "2024-01-31")  
- **Response**: Industry-level aggregate statistics.  

---

## **Performance Metrics**

Each endpoint includes performance metrics in the response, such as:  
- **Read Speed**: Time taken to execute the query.  
- **Throughput**: Data read per second.  

### **Example Response**:
```json
{
  "data": [/* ... */],
  "performanceMetrics": {
    "readSpeed": "50 ms",
    "throughput": "1024 bytes/sec"
  }
}
