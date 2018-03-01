create table Book (id bigint not null, description varchar(255),
      illustrations boolean, isbn varchar(255), nbOfPages integer,
      price float, title varchar(255), primary key (id));
create sequence hibernate_sequence start with 1 increment by 1
