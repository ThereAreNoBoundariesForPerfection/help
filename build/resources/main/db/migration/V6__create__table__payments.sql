CREATE TABLE payments (
                          id serial PRIMARY KEY,
                          sum NUMERIC  NOT NULL,
                          date VARCHAR(20) NOT NULL,
                          thing_id INTEGER REFERENCES things(id) DEFAULT NULL,
                          soldier_id INTEGER REFERENCES soldiers(id) DEFAULT NULL,
                          user_id INTEGER REFERENCES users(id)
);