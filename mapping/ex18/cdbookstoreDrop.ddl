ALTER TABLE NEWS_COMMENT DROP CONSTRAINT FK_NEWS_COMMENT_News_ID
ALTER TABLE NEWS_COMMENT DROP CONSTRAINT FK_NEWS_COMMENT_comments_ID
ALTER TABLE PURCHASEORDER_ORDERLINE DROP CONSTRAINT FK_PURCHASEORDER_ORDERLINE_orderLines_ID
ALTER TABLE PURCHASEORDER_ORDERLINE DROP CONSTRAINT FK_PURCHASEORDER_ORDERLINE_PurchaseOrder_ID
DROP TABLE ORDERLINE
DROP TABLE NEWS
DROP TABLE PURCHASEORDER
DROP TABLE COMMENT
DROP TABLE NEWS_COMMENT
DROP TABLE PURCHASEORDER_ORDERLINE
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
