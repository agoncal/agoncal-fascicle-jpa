ALTER TABLE ORDERLINE DROP CONSTRAINT FK_ORDERLINE_order_fk
ALTER TABLE jnd_art_cd DROP CONSTRAINT FK_jnd_art_cd_artist_fk
ALTER TABLE jnd_art_cd DROP CONSTRAINT FK_jnd_art_cd_cd_fk
DROP TABLE ORDERLINE
DROP TABLE ARTIST
DROP TABLE purchase_order
DROP TABLE CD
DROP TABLE jnd_art_cd
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
