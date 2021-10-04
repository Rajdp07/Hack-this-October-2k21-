CREATE TABLE IF NOT EXISTS BOOKS (
  bookID    BIGINT (11) NOT NULL,
  title   VARCHAR(100000)  NULL,
  authors   VARCHAR(4000)   NULL,
  average_rating   VARCHAR(100000)  NULL,
  isbn     VARCHAR(400) NULL,
  language_code  VARCHAR(20)   NULL,
  ratings_count  VARCHAR(50)   NULL,
  price   BIGINT (11) NOT NULL
 
);