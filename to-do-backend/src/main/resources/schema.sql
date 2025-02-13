CREATE TABLE IF NOT EXISTS todo_item (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    task_title VARCHAR(255) NOT NULL,  -- Snake case for column name
    task_description TEXT,                -- TEXT type for longer descriptions
    is_completed BOOLEAN
);