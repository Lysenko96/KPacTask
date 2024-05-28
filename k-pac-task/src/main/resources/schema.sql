CREATE DATABASE IF NOT EXISTS k_pac;

DROP TABLE IF EXISTS k_pac_k_pac_sets;
DROP TABLE IF EXISTS k_pac_set;
DROP TABLE IF EXISTS k_pac;

CREATE TABLE k_pac(
    k_pac_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(250),
    description VARCHAR(2000),
    createdAt DATE DEFAULT (CURRENT_DATE)
);

CREATE TABLE k_pac_set(
    k_pac_set_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(250)
);

CREATE TABLE k_pac_k_pac_sets(
    k_pac_id BIGINT,
    k_pac_set_id BIGINT,
    FOREIGN KEY (k_pac_id) REFERENCES k_pac(k_pac_id),
    FOREIGN KEY (k_pac_set_id) REFERENCES k_pac_set(k_pac_set_id),
    PRIMARY KEY (k_pac_id, k_pac_set_id)
);