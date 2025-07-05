CREATE TYPE roles AS ENUM('ADMIN','USER');

CREATE TABLE USERS(
    id BIGSERIAL PRIMARY KEY,
    name varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    user_roles roles
);