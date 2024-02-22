CREATE SCHEMA IF NOT EXISTS tasks_schema;
CREATE TABLE IF NOT EXISTS messages (
    id SERIAL PRIMARY KEY,
    task_id INT not null,
    parent_mess_id INT,
    title VARCHAR(100) not null,
    text VARCHAR(255),
    status VARCHAR(50),
    date_create TIMESTAMP
);
