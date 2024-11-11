# ClickHouse Database Setup

This guide walks you through setting up a ClickHouse database in a Docker container, copying CSV data files into the container, running SQL scripts to define the schema and populate the tables, and exporting CSV files from a PostgreSQL database.

## Prerequisites

- **Docker**: Ensure Docker is installed and running on your system.
- **CSV Data Files**: The following files should be available in the project directory:
  - `stock_data.csv`
  - `trade_info.csv`
  - `instrument.csv`
- **SQL Files**:
  - `schema.sql` — contains the schema definitions for the tables.
  - `seed.sql` — contains SQL commands for seeding the tables with initial data.

## Steps


### 1. Exporting Files from PostgreSQL Database

To export data from your PostgreSQL database into CSV files, use the following SQL commands:

```sql
COPY (SELECT * FROM stock_data) 
TO '/path/to/your/exported_stock_data.csv' 
WITH (FORMAT CSV, HEADER);

COPY (SELECT * FROM instrument) 
TO '/path/to/your/exported_price_info.csv' 
WITH (FORMAT CSV, HEADER);

COPY (SELECT * FROM trade_info) 
TO '/path/to/your/exported_trade_info.csv' 
WITH (FORMAT CSV, HEADER);
```

### 2. Start the ClickHouse Server

Start a ClickHouse server in a Docker container with the following command:

```bash
docker run -d --name some-clickhouse-server --ulimit nofile=262144:262144 clickhouse/clickhouse-server
```

### 3. Copy CSV Files into the Container

Copy the CSV files from your local machine into the container for data loading:

```bash
docker cp ./stock_data.csv some-clickhouse-server:/tmp/stock_data.csv
docker cp ./trade_info.csv some-clickhouse-server:/tmp/trade_info.csv
docker cp ./instrument.csv some-clickhouse-server:/tmp/price_info.csv
```

### 4. Access the ClickHouse Client

Once the container is running, connect to it using the ClickHouse client:

```bash
docker exec -it some-clickhouse-server clickhouse-client
```

### 5. Apply the Schema

Use the `schema.sql` file to define the schema within ClickHouse. Copy `schema.sql` into the container and execute it:

```bash
docker cp ./schema.sql some-clickhouse-server:/tmp/schema.sql
docker exec -it some-clickhouse-server clickhouse-client --query="SOURCE /tmp/schema.sql"
```

### 6. Seed the Database

To populate the database with postgreSQL tables data from `seed.sql`, copy `seed.sql` into the container and execute it:

```bash
docker cp ./seed.sql some-clickhouse-server:/tmp/seed.sql
docker exec -it some-clickhouse-server clickhouse-client --query="SOURCE /tmp/seed.sql"
```

