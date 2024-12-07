-- we can use Liquibase script to maintain versioning
CREATE SCHEMA IF NOT EXISTS hackathon_mortgage_db;
             SET SCHEMA hackathon_mortgage_db;
             CREATE TABLE test_tbl (name VARCHAR(100) identity NOT NULL, email VARCHAR(100) NULL);