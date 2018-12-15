create table book (
  id bigint not null,
  illustrations boolean,
  isbn varchar(255),
  nbOfPages integer,
  publisher varchar(255),
  primary key (id)
)
