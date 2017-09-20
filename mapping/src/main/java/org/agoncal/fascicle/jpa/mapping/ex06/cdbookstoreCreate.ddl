create table News (
  language varchar(255) not null,
  title varchar(255) not null,
  content varchar(255),
  primary key (language, title)
)
