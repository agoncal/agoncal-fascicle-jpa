create table Customer (
  id bigint not null,
  firstName varchar(255),
  lastName varchar(255),
  email varchar(255),
  phoneNumber varchar(255),
  address_id bigint,
  primary key (id),
  foreign key (address_id) references Address(id)
);
