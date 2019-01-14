create table Book
(
  id          bigint       not null,
  description varchar(2000),
  isbn        varchar(13),
  nbOfPages   integer,
  price       float,
  title       varchar(255) not null,
  primary key (id)
)
