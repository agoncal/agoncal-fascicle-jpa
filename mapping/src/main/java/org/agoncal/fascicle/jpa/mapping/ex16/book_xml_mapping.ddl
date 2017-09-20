create table book_xml_mapping (
  id bigint not null,
  book_title varchar(255) not null,
  description varchar(2000),
  nb_of_pages integer not null,
  price float,
  isbn varchar(255),
  illustrations boolean,
  primary key (id)
)
