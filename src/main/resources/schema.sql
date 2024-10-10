CREATE TABLE IF NOT EXISTS Card (
    id              INT             NOT NULL,
    correct         INT             DEFAULT 0,
    wrong           INT             DEFAULT 0,
    skipped         INT             DEFAULT 0,
    question        VARCHAR(250)    NOT NULL,
    answer          VARCHAR(250)    NOT NULL,
    category        VARCHAR(5)      NOT NULL,
    date_created    TIMESTAMP       NOT NULL,
    date_edited     TIMESTAMP       NOT NULL,

    PRIMARY KEY (id)
);