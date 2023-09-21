CREATE TABLE
    IF NOT EXISTS states (
        id INT PRIMARY KEY AUTO_INCREMENT,
        name VARCHAR(255) NOT NULL
    );

ALTER TABLE users
ADD state_id INT NOT NULL,
ADD name VARCHAR(255) NOT NULL,
ADD
    last_name VARCHAR(255) NOT NULL,
ADD
    application TINYINT(1) NOT NULL DEFAULT 0,
ADD
    password VARCHAR(255) NOT NULL;

CREATE TABLE
    IF NOT EXISTS posts (
        id INT PRIMARY KEY AUTO_INCREMENT,
        title VARCHAR(255) NOT NULL,
        body VARCHAR(255) NOT NULL,
        image_id INT NOT NULL,
        is_notice TINYINT(1) NOT NULL DEFAULT 0,
        creation_date DATE NOT NULL,
        garden_id INT NOT NULL,
        plantation_id INT NOT NULL,
        tag_id INT NOT NULL,
        comments_id INT NOT NULL
    );

CREATE TABLE
    IF NOT EXISTS garden (
        id INT PRIMARY KEY AUTO_INCREMENT,
        cellphone VARCHAR(255) NOT NULL,
        home_id INT NOT NULL,
        accepted TINYINT(1) NOT NULL DEFAULT 0,
        plantation_id INT NOT NULL
    );

CREATE TABLE
    IF NOT EXISTS plantation (
        id INT PRIMARY KEY AUTO_INCREMENT,
        cropType_id INT NOT NULL,
        harvest_id INT NOT NULL,
        cropVariety_id INT NOT NULL,
        plantationState_id INT NOT NULL,
        additional_notes VARCHAR(255) NOT NULL,

        
    );