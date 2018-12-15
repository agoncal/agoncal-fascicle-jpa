create table jnd_ord_line (
  order_fk bigint not null,
  order_line_fk bigint not null,
  primary key (order_fk, order_line_fk),
  foreign key (order_line_fk) references OrderLine(id),
  foreign key (order_fk) references Order(id)
)
