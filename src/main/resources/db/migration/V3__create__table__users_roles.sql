CREATE TABLE users_roles (
                       user_id INTEGER REFERENCES users(id),
                       role_id INTEGER REFERENCES roles(id)
);