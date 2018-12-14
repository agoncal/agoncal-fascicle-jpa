create table Book (
  id bigint not null,
  book_title varchar(255) not null,
  price float,
  description varchar(2000),
  isbn varchar(255),
  nb_of_pages integer not null,
  illustrations boolean,
  primary key (id)
)
