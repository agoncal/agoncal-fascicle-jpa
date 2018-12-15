create table Customer (
  id bigint not null,
  first_name varchar(50) not null,
  last_name varchar(50) not null,
  email varchar(255),
  phone_number varchar(555),
  street1 varchar(255),
  street2 varchar(255),
  zipcode varchar(255),
  state varchar(255),
  city varchar(255),
  country varchar(255),
  primary key (id)
)
