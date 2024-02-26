CREATE SCHEMA IF NOT EXISTS tasks_schema;
DROP TABLE IF EXISTS tasks;
CREATE TABLE IF NOT EXISTS tasks (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) not null,
    description VARCHAR(255),
    status VARCHAR(50) DEFAULT 'NEW_TASK',
    date_create TIMESTAMP DEFAULT current_timestamp,
    date_complete TIMESTAMP
);