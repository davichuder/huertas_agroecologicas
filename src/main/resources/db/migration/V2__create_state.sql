CREATE TABLE
    IF NOT EXISTS states (
        id INT PRIMARY KEY AUTO_INCREMENT,
        name VARCHAR(255) NOT NULL
    );

ALTER TABLE users
ADD state_id int NOT NULL;