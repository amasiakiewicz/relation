create table posting
(
    id                UUID PRIMARY KEY,
    version           INT                      NOT NULL,
    created_date_time TIMESTAMP WITH TIME ZONE NOT NULL,
    date              DATE                     NOT NULL,
    account           VARCHAR(26)              NOT NULL,
    amount_currency   VARCHAR(3)               NOT NULL,
    amount_value      NUMERIC(15, 2)           NOT NULL,
    description       VARCHAR(50)              NOT NULL UNIQUE
);
