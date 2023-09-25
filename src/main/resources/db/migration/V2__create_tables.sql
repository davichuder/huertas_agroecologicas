CREATE TABLE
    IF NOT EXISTS states (
        id VARCHAR(255) PRIMARY KEY,
        name VARCHAR(255) NOT NULL
    );

CREATE TABLE
    IF NOT EXISTS comments (
        id VARCHAR(255) PRIMARY KEY,
        body VARCHAR(255) NOT NULL,
        creation_date DATE NOT NULL,
        post_id VARCHAR(255) NOT NULL
    );

CREATE TABLE
    IF NOT EXISTS posts (
        id VARCHAR(255) PRIMARY KEY,
        title VARCHAR(255) NOT NULL,
        body VARCHAR(2550) NOT NULL,
        image_id VARCHAR(255),
        is_notice TINYINT(1) NOT NULL DEFAULT 0,
        creation_date DATE NOT NULL,
        garden_id VARCHAR(255),
        plantation_id VARCHAR(255),
        tag_id VARCHAR(255) NOT NULL,
        user_id VARCHAR(255) NOT NULL
    );

ALTER TABLE users
ADD password VARCHAR(255) NOT NULL,
ADD image_id VARCHAR(255),
ADD name VARCHAR(255) NOT NULL,
ADD last_name VARCHAR(255) NOT NULL,
ADD state_id VARCHAR(255) NOT NULL,
ADD application TINYINT(1) NOT NULL DEFAULT 0;

CREATE TABLE
    IF NOT EXISTS images (
        id VARCHAR(255) PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        mime VARCHAR(255) NOT NULL,
        content LONGBLOB
    );

CREATE TABLE
    IF NOT EXISTS gardens (
        id VARCHAR(255) PRIMARY KEY,
        home_id VARCHAR(255) NOT NULL,
        accepted TINYINT(1) NOT NULL DEFAULT 0,
        producer_id VARCHAR(255) NOT NULL
    );

CREATE TABLE
    IF NOT EXISTS plantations (
        id VARCHAR(255) PRIMARY KEY,
        cropType_id VARCHAR(255) NOT NULL,
        harvest_id VARCHAR(255) NOT NULL,
        cropVariety_id VARCHAR(255) NOT NULL,
        plantationState_id VARCHAR(255) NOT NULL,
        additional_notes VARCHAR(2550) NOT NULL,
        garden_id VARCHAR(255) NOT NULL
    );

CREATE TABLE
    IF NOT EXISTS sowings (
        id VARCHAR(255) PRIMARY KEY,
        plantation_id VARCHAR(255) NOT NULL,
        harvest_estimated_date DATE NOT NULL,
        sowing_ammount INT NOT NULL,
        sowing_date DATE NOT NULL,
    );

CREATE TABLE
    IF NOT EXISTS crop_types (
        id VARCHAR(255) PRIMARY KEY,
        name VARCHAR(255) NOT NULL
    );

CREATE TABLE
    IF NOT EXISTS crop_varieties (
        id VARCHAR(255) PRIMARY KEY,
        name VARCHAR(255) NOT NULL
    );