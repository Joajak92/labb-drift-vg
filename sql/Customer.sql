CREATE TABLE customer
(
    id         BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(40),
    last_name  VARCHAR(40),
    email      VARCHAR(100)
);