CREATE TABLE things (
                       id serial PRIMARY KEY,
                       name VARCHAR(100) UNIQUE NOT NULL,
                       quantity INTEGER NOT NULL,
                       need_funds NUMERIC NOT NULL,
                       collected_funds NUMERIC DEFAULT 0 NOT NULL,
                       description text
);