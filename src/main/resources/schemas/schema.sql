-- schema.sql

CREATE TABLE IF NOT EXISTS language (
    id INT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS countries (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    fk_language_id INT,
    FOREIGN KEY (fk_language_id) REFERENCES language(id)
);

CREATE TABLE IF NOT EXISTS states (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    fk_country_id INT,
    fk_language_id INT,
    FOREIGN KEY (fk_country_id) REFERENCES countries(id),
    FOREIGN KEY (fk_language_id) REFERENCES language(id)
);

CREATE TABLE IF NOT EXISTS cities (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    fk_state_id INT,
    fk_language_id INT,
    FOREIGN KEY (fk_state_id) REFERENCES states(id),
    FOREIGN KEY (fk_language_id) REFERENCES language(id)
);



CREATE TABLE IF NOT EXISTS person (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    fk_language_fid INT,
    fk_city_fid INT,
    fk_country_fid INT,
    fk_state_fid INT,
    FOREIGN KEY (fk_language_fid) REFERENCES language(id),
    FOREIGN KEY (fk_city_fid) REFERENCES cities(id),
    FOREIGN KEY (fk_country_fid) REFERENCES countries(id),
    FOREIGN KEY (fk_state_fid) REFERENCES states(id)
);
