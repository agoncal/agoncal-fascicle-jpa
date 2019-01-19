CREATE TABLE BOOK_XML_MAPPING
(
  ID            BIGINT       NOT NULL,
  BOOK_TITLE    VARCHAR(255) NOT NULL,
  DESCRIPTION   VARCHAR(2000),
  NB_OF_PAGES   INTEGER      NOT NULL,
  PRICE         FLOAT,
  ISBN          VARCHAR(255),
  ILLUSTRATIONS BOOLEAN,
  PRIMARY KEY (ID)
)
