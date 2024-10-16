CREATE TABLE IF NOT EXISTS Card (
    id              SERIAL          PRIMARY KEY,
    correct         INT             DEFAULT 0,
    wrong           INT             DEFAULT 0,
    skipped         INT             DEFAULT 0,
    question        VARCHAR(250)    NOT NULL,
    answer          VARCHAR(250)    NOT NULL,
    category        VARCHAR(6)      NOT NULL,
    date_created    TIMESTAMP       DEFAULT CURRENT_TIMESTAMP,
    date_edited     TIMESTAMP       DEFAULT NULL
);