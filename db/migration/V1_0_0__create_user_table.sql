CREATE TABLE IF NOT EXISTS "user"
(
    id         bigserial NOT NULL,
    name       text      NOT NULL,
    password   text      NOT NULL,
    dat_create TIMESTAMP NOT NULL,
    dat_update TIMESTAMP,
    CONSTRAINT user_pk PRIMARY KEY (id) USING INDEX TABLESPACE tsi01
) TABLESPACE tsd01;

INSERT INTO "user"(id, name, password, dat_create, dat_update) VALUES (1, 'admin', 'admin', now(), now());