-- liquibase formatted sql

-- changeset ehsan-sadr:1763219200028-1
CREATE SEQUENCE IF NOT EXISTS book_seq START WITH 1 INCREMENT BY 1;

-- changeset ehsan-sadr:1763219200028-2
CREATE TABLE books
(
    id         BIGINT NOT NULL,
    title      VARCHAR(255),
    author     VARCHAR(255),
    print_year INTEGER,
    edition    VARCHAR(255),
    price      DOUBLE PRECISION,
    publisher  VARCHAR(255),
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    deleted_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_books PRIMARY KEY (id)
);