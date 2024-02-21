CREATE SCHEMA IF NOT EXISTS tasks_schema;
CREATE TABLE IF NOT EXISTS tasks (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) not null,
    description VARCHAR(255),
    status VARCHAR(50) not null,
    date_create TIMESTAMP,
    date_complete TIMESTAMP
);