CREATE TABLE parts (
    id            int    PRIMARY KEY AUTO_INCREMENT,
    desc          VARCHAR(50)    NOT NULL,
    price         decimal(8,2)   NOT NULL,
    weight        decimal(4,2)   NOT NULL,
    pictureURL    VARCHAR(50)    NOT NULL
);

CREATE TABLE cart (
    id     int          PRIMARY KEY AUTO_INCREMENT,
    partID int          NOT NULL,
    item   varchar(255) DEFAULT NULL,
    qty    int          DEFAULT 1,
    price  decimal(8,2) DEFAULT 0,
    weight decimal(4,2) DEFAULT 0,

    FOREIGN KEY (partID) REFERENCES parts(id)
);

CREATE TABLE taxes (
    id            int    PRIMARY KEY AUTO_INCREMENT,
    weightBracket int    NOT NULL,
    taxRate       float  NOT NULL
);

CREATE TABLE orders (
    id            int    PRIMARY KEY AUTO_INCREMENT,
    partID        int    NOT NULL,
    qty           int    DEFAULT 1,
    email         VARCHAR(255),
    status        int DEFAULT 1,

    FOREIGN KEY (partID) REFERENCES parts(id)
);

CREATE TABLE inventory (
    id            int    PRIMARY KEY AUTO_INCREMENT,
    partID        int    NOT NULL,
    qty           int    DEFAULT 0,

    FOREIGN KEY (partID) REFERENCES parts(id)
);

