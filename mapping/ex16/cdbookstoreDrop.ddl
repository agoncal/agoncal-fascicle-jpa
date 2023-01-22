ALTER TABLE jnd_ord_line DROP CONSTRAINT FK_jnd_ord_line_order_line_fk
ALTER TABLE jnd_ord_line DROP CONSTRAINT FK_jnd_ord_line_order_fk
DROP TABLE ORDERLINE
DROP TABLE purchase_order
DROP TABLE jnd_ord_line
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
