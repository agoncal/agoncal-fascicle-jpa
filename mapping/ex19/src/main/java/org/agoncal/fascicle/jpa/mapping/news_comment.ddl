create table news_comment (
  news_id bigint not null,
  comments_id bigint not null,
  publication_index integer not null,
  primary key (news_id, publication_index)
)
