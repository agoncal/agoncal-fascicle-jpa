ALTER TABLE purchase_order_ORDERLINE DROP CONSTRAINT FK_purchase_order_ORDERLINE_orderLines_ID
ALTER TABLE purchase_order_ORDERLINE DROP CONSTRAINT FK_purchase_order_ORDERLINE_PurchaseOrder_ID
DROP TABLE ORDERLINE
DROP TABLE purchase_order
DROP TABLE purchase_order_ORDERLINE
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
