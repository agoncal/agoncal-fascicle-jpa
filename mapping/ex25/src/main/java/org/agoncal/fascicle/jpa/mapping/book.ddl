create table book (
  id bigint not null,
  description varchar(2000),
  price float,
  title varchar(50) not null,
  illustrations boolean,
  isbn varchar(255),
  nbOfPages integer,
  publisher varchar(255),
  primary key (id)
)
