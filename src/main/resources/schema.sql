
USE springjdbc;

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS country;
DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS purchase_books;
DROP TABLE IF EXISTS shop;
DROP TABLE IF EXISTS book_price;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE IF NOT EXISTS country (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255),
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS account (
  id INT NOT NULL AUTO_INCREMENT,
  amount BIGINT(15),
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS city (
 id INT NOT NULL AUTO_INCREMENT,
 name VARCHAR(255),
 country_id INT,

 PRIMARY KEY (id),
 INDEX country_id (country_id),

 FOREIGN KEY (country_id)
    REFERENCES country(id)
    ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS user (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255),
  email VARCHAR(255),
  age INT,
  city_id INT,
  account_id INT,

  PRIMARY KEY (id),
  INDEX city_id (city_id),
  INDEX account_id (account_id),

  FOREIGN KEY (city_id)
     REFERENCES city(id)
     ON DELETE CASCADE,

  FOREIGN KEY (account_id)
     REFERENCES account(id)
     ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS author (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255),
  age INT,
  city_id INT,

  PRIMARY KEY (id),
  INDEX city_id (city_id),

  FOREIGN KEY (city_id)
     REFERENCES city(id)
     ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS book (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255),
  price INT,
  author_id INT,

  PRIMARY KEY (id),
  INDEX author_id (author_id),

  FOREIGN KEY (author_id)
     REFERENCES author(id)
     ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS purchase_book (
  book_id INT,
  user_id INT,

  INDEX user_id (user_id),
  INDEX book_id (book_id),

  FOREIGN KEY (user_id)
     REFERENCES user(id)
     ON DELETE CASCADE,

  FOREIGN KEY (book_id)
     REFERENCES book(id)
     ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS shop (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255),
  city_id INT,
  account_id INT,

  PRIMARY KEY (id),
  INDEX city_id (city_id),
  INDEX account_id (account_id),

  FOREIGN KEY (city_id)
     REFERENCES city(id)
     ON DELETE CASCADE,

  FOREIGN KEY (account_id)
     REFERENCES account(id)
     ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS book_price (
  book_id INT,
  shop_id INT,
  price INT,

  INDEX book_id (book_id),
  INDEX shop_id (shop_id),

  FOREIGN KEY (book_id)
     REFERENCES book(id)
     ON DELETE CASCADE,

  FOREIGN KEY (shop_id)
     REFERENCES shop(id)
     ON DELETE CASCADE
);


