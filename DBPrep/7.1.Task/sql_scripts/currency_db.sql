-- Drop previous database if it exists
DROP DATABASE IF EXISTS currency_db;

-- Create the database
CREATE DATABASE currency_db;
USE currency_db;

-- Create Currency table (minimal API-only design)
CREATE TABLE Currency (
                          abbreviation VARCHAR(10) NOT NULL PRIMARY KEY,
                          rate_to_usd DECIMAL(18, 8) NOT NULL
);

-- Drop appuser if it exists
DROP USER IF EXISTS 'appuser'@'localhost';

-- Create appuser account
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'MyS3cur3P@ssw0rd!';

-- Grant privileges needed by the application
GRANT SELECT, INSERT, UPDATE ON currency_db.* TO 'appuser'@'localhost';

-- Apply privileges
FLUSH PRIVILEGES;
