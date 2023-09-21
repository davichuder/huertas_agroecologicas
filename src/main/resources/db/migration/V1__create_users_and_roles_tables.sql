CREATE TABLE
    IF NOT EXISTS roles (
        id VARCHAR(255) PRIMARY KEY,
        name VARCHAR(255) NOT NULL
    );
CREATE TABLE
    IF NOT EXISTS users (
        id VARCHAR(255) PRIMARY KEY,
        email VARCHAR(255) NOT NULL,
        role_id VARCHAR(255) NOT NULL,
        FOREIGN KEY (role_id) REFERENCES roles (id)
    );