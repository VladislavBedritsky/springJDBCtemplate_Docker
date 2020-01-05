USE springjdbc;

INSERT INTO users (name, email, age) VALUES ('Jack', 'jack@mail.com', 32);
INSERT INTO users (name, email, age) VALUES ('Kyle', 'kyle@mail.com', 42);
INSERT INTO users (name, email, age) VALUES ('Trent', 'trent@mail.com', 27);

INSERT INTO authors (name, age) VALUES ('J.ROWLING', 32);
INSERT INTO authors (name, age) VALUES ('T.GOODKIND', 42);
INSERT INTO authors (name, age) VALUES ('D.BROWN',  27);

INSERT INTO books (name, price, author_id) VALUES ('Harry Potter 1', 16, 1);
INSERT INTO books (name, price, author_id) VALUES ('1 Rule of Magic', 15, 2);
INSERT INTO books (name, price, author_id) VALUES ('Angels and Demons', 13, 3);

INSERT INTO purchase_books (book_id, user_id) VALUES (1, 1);
INSERT INTO purchase_books (book_id, user_id) VALUES (2, 1);
INSERT INTO purchase_books (book_id, user_id) VALUES (2, 2);
INSERT INTO purchase_books (book_id, user_id) VALUES (3, 2);
INSERT INTO purchase_books (book_id, user_id) VALUES (1, 3);
INSERT INTO purchase_books (book_id, user_id) VALUES (3, 3);