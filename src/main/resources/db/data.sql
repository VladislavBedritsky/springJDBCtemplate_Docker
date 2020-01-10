USE springjdbc;

INSERT INTO country (id, name) VALUES (1, 'Belarus');
INSERT INTO country (id, name) VALUES (2, 'France');
INSERT INTO country (id, name) VALUES (3, 'Russia');
INSERT INTO country (id, name) VALUES (4, 'England');

INSERT INTO account (id, amount) VALUES (1, 15000);
INSERT INTO account (id, amount) VALUES (2, 800);
INSERT INTO account (id, amount) VALUES (3, 300);
INSERT INTO account (id, amount) VALUES (4, 132000);
INSERT INTO account (id, amount) VALUES (5, 1320);
INSERT INTO account (id, amount) VALUES (6, 7843);
INSERT INTO account (id, amount) VALUES (7, 17843);
INSERT INTO account (id, amount) VALUES (8, 9002);
INSERT INTO account (id, amount) VALUES (9, 41005);

INSERT INTO city (id, name, country_id) VALUES (1, 'Brest', 1);
INSERT INTO city (id, name, country_id) VALUES (2, 'Brest', 2);
INSERT INTO city (id, name, country_id) VALUES (3, 'Moscow', 3);
INSERT INTO city (id, name, country_id) VALUES (4, 'London', 4);
INSERT INTO city (id, name, country_id) VALUES (5, 'Liverpool', 4);
INSERT INTO city (id, name, country_id) VALUES (6, 'Minsk', 1);

INSERT INTO user (id, name, email, age, city_id, account_id) VALUES (1, 'Jack', 'jack@mail.com', 32, 1, 2);
INSERT INTO user (id, name, email, age, city_id, account_id) VALUES (2, 'Kyle', 'kyle@mail.com', 42, 2, 5);
INSERT INTO user (id, name, email, age, city_id, account_id) VALUES (3, 'Trent', 'trent@mail.com', 27, 3, 1);

INSERT INTO author (id, name, age, city_id) VALUES (1, 'J.ROWLING', 32, 4);
INSERT INTO author (id, name, age, city_id) VALUES (2, 'T.GOODKIND', 42, 5);
INSERT INTO author (id, name, age, city_id) VALUES (3, 'D.BROWN',  27, 4);

INSERT INTO book (id, name, author_id) VALUES (1, 'Harry Potter 1', 1);
INSERT INTO book (id, name, author_id) VALUES (2, '1 Rule of Magic', 2);
INSERT INTO book (id, name, author_id) VALUES (3, 'Angels and Demons', 3);

INSERT INTO purchase_book (book_id, user_id) VALUES (1, 1);
INSERT INTO purchase_book (book_id, user_id) VALUES (2, 1);
INSERT INTO purchase_book (book_id, user_id) VALUES (2, 2);
INSERT INTO purchase_book (book_id, user_id) VALUES (3, 2);
INSERT INTO purchase_book (book_id, user_id) VALUES (1, 3);
INSERT INTO purchase_book (book_id, user_id) VALUES (3, 3);

INSERT INTO shop (id, name, city_id, account_id) VALUES (1, 'ABooks.com', 4, 3);
INSERT INTO shop (id, name, city_id, account_id) VALUES (2, 'Litres.ru', 3, 4);
INSERT INTO shop (id, name, city_id, account_id) VALUES (3, 'Booksinfo.io', 5, 6);
INSERT INTO shop (id, name, city_id, account_id) VALUES (4, 'BookHouse.by', 1, 7);
INSERT INTO shop (id, name, city_id, account_id) VALUES (5, 'LibraryLon.org', 2, 8);
INSERT INTO shop (id, name, city_id, account_id) VALUES (6, 'KingBook.ru', 6, 9);

INSERT INTO book_price (book_id, shop_id, price) VALUES (1, 2, 18);
INSERT INTO book_price (book_id, shop_id, price) VALUES (2, 2, 16);
INSERT INTO book_price (book_id, shop_id, price) VALUES (3, 2, 17);
INSERT INTO book_price (book_id, shop_id, price) VALUES (1, 1, 19);
INSERT INTO book_price (book_id, shop_id, price) VALUES (1, 4, 16);
INSERT INTO book_price (book_id, shop_id, price) VALUES (1, 5, 15);
INSERT INTO book_price (book_id, shop_id, price) VALUES (2, 3, 15);
INSERT INTO book_price (book_id, shop_id, price) VALUES (2, 6, 16);
INSERT INTO book_price (book_id, shop_id, price) VALUES (3, 1, 15);
INSERT INTO book_price (book_id, shop_id, price) VALUES (3, 6, 18);