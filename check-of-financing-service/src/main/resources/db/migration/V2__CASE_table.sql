CREATE TABLE public."financing"
(
    financeObject text NOT NULL,
    amount bigint NOT NULL,
    status text NOT NULL,
    PRIMARY KEY (financeObject)
);

ALTER TABLE public."financing"
    OWNER to dbuser;
