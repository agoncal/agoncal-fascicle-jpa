CREATE TABLE COMMENT
(
  ID                BIGINT NOT NULL,
  CONTENT           VARCHAR,
  NICKNAME          VARCHAR,
  NOTE              INTEGER,
  COMMENTS_ID       BIGINT,
  publication_index INTEGER,
  PRIMARY KEY (ID)
)
