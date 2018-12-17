CREATE TABLE jnd_ord_line
(
  order_fk      BIGINT NOT NULL,
  order_line_fk BIGINT NOT NULL,
  PRIMARY KEY (order_fk, order_line_fk)
);
ALTER TABLE jnd_ord_line
  ADD CONSTRAINT FK_jnd_ord_line_order_line_fk FOREIGN KEY (order_line_fk) REFERENCES ORDERLINE (ID);
ALTER TABLE jnd_ord_line
  ADD CONSTRAINT FK_jnd_ord_line_order_fk FOREIGN KEY (order_fk) REFERENCES purchase_order (ID);
