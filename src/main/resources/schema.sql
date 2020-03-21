DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS users_roles CASCADE;
DROP TABLE IF EXISTS product CASCADE;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE users
(
    id              INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name            VARCHAR(255)    NOT NULL,
    password        VARCHAR(255)    NOT NULL,
    CONSTRAINT constraint_unique_user_name UNIQUE(name)
);

CREATE TABLE user_roles
(
    user_id         INTEGER NOT NULL,
    role            VARCHAR(255),
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
