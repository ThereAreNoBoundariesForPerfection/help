CREATE TABLE soldiers (
                        id serial PRIMARY KEY,
                        first_name VARCHAR(20) NOT NULL,
                        last_name VARCHAR(20) NOT NULL,
                        phone VARCHAR(30) UNIQUE NOT NULL,
                        email VARCHAR(40) UNIQUE NOT NULL,
                        need_funds NUMERIC NOT NULL,
                        collected_funds NUMERIC DEFAULT 0 NOT NULL,
                        description_damage_health text
);