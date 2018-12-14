create table Book (
  id bigint not null,
  title varchar(255),
  price float,
  description varchar(255),
  isbn varchar(255),
  nbOfPages integer,
  illustrations boolean,
  primary key (id)
)
