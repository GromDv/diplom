CREATE SCHEMA IF NOT EXISTS tasks_schema;
DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    dev_id INT default 0,
    username VARCHAR(100) not null,
    password VARCHAR(100) not null,
    last_name VARCHAR(100) not null,
    e_mail VARCHAR(100) not null,
    status VARCHAR(50),
    date_create TIMESTAMP default current_timestamp,
    date_expired TIMESTAMP,
    is_enabled BOOLEAN default true
);
