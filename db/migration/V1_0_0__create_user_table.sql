CREATE TABLE IF NOT EXISTS "user"
(
    id         bigserial NOT NULL,
    name       text      NOT NULL,
    password   text      NOT NULL,
    dat_create TIMESTAMP NOT NULL,
    dat_update TIMESTAMP,
    CONSTRAINT user_pk PRIMARY KEY (id) USING INDEX TABLESPACE tsi01
) TABLESPACE tsd01;

CREATE TABLE IF NOT EXISTS "role"
(
    id         bigserial NOT NULL,
    name       text      NOT NULL,
    dat_create TIMESTAMP NOT NULL,
    dat_update TIMESTAMP,
    CONSTRAINT role_pk PRIMARY KEY (id) USING INDEX TABLESPACE tsi01
) TABLESPACE tsd01;

CREATE TABLE IF NOT EXISTS "user_role"
(
    id         bigserial NOT NULL,
    id_user    bigint references "user"(id),
    id_role    bigint references "role"(id)
) TABLESPACE tsd01;

INSERT INTO "user"(name, password, dat_create, dat_update) VALUES ('admin', '$2a$10$CevqWbX3ohdY3762Pai9Sufjo6JkkLrWMsXQC8PPNUBshF5JyLYP2', now(), null);
INSERT INTO "role"(name, dat_create, dat_update) VALUES ('ROLE_ADMIN', now(), null);
INSERT INTO "role"(name, dat_create, dat_update) VALUES ('ROLE_USER', now(), null);
INSERT INTO "user_role"(id_user, id_role) VALUES (1, 1);