CREATE TABLE cart (
    id    int          AUTO_INCREMENT NOT NULL,
    item  varchar(255) DEFAULT NULL,
    qty   int          DEFAULT 1,
    price float        DEFAULT 0
);