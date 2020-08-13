FROM postgres
EXPOSE 5432

ENV POSTGRES_USER admin
ENV POSTGRES_PASSWORD admin
ENV POSTGRES_DB security_db

RUN mkdir -p /tablespace/data
RUN mkdir -p /tablespace/index

RUN chown -R postgres:postgres /tablespace
RUN chmod 777 /tablespace/data
RUN chmod 777 /tablespace/index

ADD initial.sql /docker-entrypoint-initdb.d/