ALTER TABLE CUSTOMER DROP CONSTRAINT FK_CUSTOMER_add_fk
ALTER TABLE purchase_order_order_line DROP CONSTRAINT FK_purchase_order_order_line_orderLines_ID
ALTER TABLE purchase_order_order_line DROP CONSTRAINT FK_purchase_order_order_line_PurchaseOrder_ID
DROP TABLE order_line
DROP TABLE ADDRESS
DROP TABLE purchase_order
DROP TABLE CUSTOMER
DROP TABLE purchase_order_order_line
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
