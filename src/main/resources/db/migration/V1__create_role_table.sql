CREATE TABLE
    IF NOT EXISTS role (
        id INT NOT NULL AUTO_INCREMENT,
        name VARCHAR(32) NOT NULL,
        PRIMARY KEY (id),
        UNIQUE KEY uk_name (name)
    ) ENGINE = MyISAM DEFAULT CHARSET = utf8;

CREATE TABLE
    IF NOT EXISTS users (
        id INT NOT NULL AUTO_INCREMENT,
        email VARCHAR(255) NOT NULL,
        rol_id INT NOT NULL,
        PRIMARY KEY (id)
        FOREIGN KEY (rol_id) REFERENCES rol (id)
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8;