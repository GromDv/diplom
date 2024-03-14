DROP TABLE IF EXISTS files_tasks;
CREATE TABLE IF NOT EXISTS files_tasks (
    id SERIAL PRIMARY KEY,
    filename VARCHAR(255) not null,
    task_id INT not null
);
