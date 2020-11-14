CREATE TABLE cart (
    id    int          PRIMARY KEY AUTO_INCREMENT,
    item  varchar(255) DEFAULT NULL,
    qty   int          DEFAULT 1,
    price float        DEFAULT 0
);

CREATE TABLE taxes (
    id            int    PRIMARY KEY AUTO_INCREMENT,
    weightBracket int    NOT NULL,
    taxRate       float  NOT NULL
);