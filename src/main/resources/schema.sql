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
CREATE TABLE orders(
    id            int    AUTO_INCREMENT,
    item_id       int    NOT NULL,
    qty           int    DEFAULT 1,
    email         varchar(255) NOT NULL,
    status        boolean DEFAULT 0,
    PRIMARY KEY (id)
);