CREATE TABLE users (
                       id serial PRIMARY KEY,
                       first_name VARCHAR(40) NOT NULL,
                       last_name VARCHAR(40) NOT NULL,
                       email VARCHAR(40) UNIQUE NOT NULL,
                       password VARCHAR(200) UNIQUE NOT NULL
);