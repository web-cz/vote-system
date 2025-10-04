CREATE DATABASE IF NOT EXISTS votesystem;

CREATE TABLE IF NOT EXISTS vote_item
(
    item_id         INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    item_name       VARCHAR(128) NOT NULL,
    item_total      INT NOT NULL DEFAULT 0,
    item_created_time       TIMESTAMP NOT NULL,
    item_last_modified_time TIMESTAMP NOT NULL
);


CREATE TABLE IF NOT EXISTS vote_record
(
    record_id        INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    voter_name       VARCHAR(128) NOT NULL,
    voter_name_norm  VARCHAR(128) GENERATED ALWAYS AS (LOWER(TRIM(voter_name))) STORED,
    item_id          INT NOT NULL,
    vote_time        TIMESTAMP NOT NULL,

    CONSTRAINT fk_record_item_id
    FOREIGN KEY (item_id) REFERENCES vote_item(item_id)
    ON DELETE RESTRICT,

    UNIQUE KEY uk_record_item_id_name (item_id, voter_name_norm)
);