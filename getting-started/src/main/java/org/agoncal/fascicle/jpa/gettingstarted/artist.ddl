create table Artist (
  id bigint not null,
  bio varchar(2000),
  dateofbirth date,
  email varchar,
  firstname varchar not null,
  lastname varchar not null,
  primary key (id)
)
