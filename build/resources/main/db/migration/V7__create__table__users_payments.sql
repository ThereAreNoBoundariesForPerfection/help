CREATE TABLE users_payments (
                                user_id INTEGER REFERENCES user(id),
                                payments_id INTEGER REFERENCES payments(id)
);