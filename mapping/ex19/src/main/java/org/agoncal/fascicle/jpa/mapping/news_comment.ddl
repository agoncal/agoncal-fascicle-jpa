CREATE TABLE NEWS_COMMENT
(
  News_ID           BIGINT NOT NULL,
  comments_ID       BIGINT NOT NULL,
  publication_index INTEGER,
  PRIMARY KEY (News_ID, comments_ID)
)
