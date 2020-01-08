
USE springjdbc;

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS authors;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS purchase_books;
SET FOREIGN_KEY_CHECKS = 1;

  CREATE TABLE IF NOT EXISTS users (
      id INT NOT NULL AUTO_INCREMENT,
      name VARCHAR(255),
      email VARCHAR(255),
      age INT,
      PRIMARY KEY (id)
  );

   CREATE TABLE IF NOT EXISTS authors (
        id INT NOT NULL AUTO_INCREMENT,
        name VARCHAR(255),
        age INT,
        PRIMARY KEY (id)
    );

  CREATE TABLE IF NOT EXISTS books (
        id INT NOT NULL AUTO_INCREMENT,
        name VARCHAR(255),
        price INT,
        author_id INT,

        PRIMARY KEY (id),
        INDEX author_id (author_id),

        FOREIGN KEY (author_id)
            REFERENCES authors(id)
            ON DELETE CASCADE
    );

    CREATE TABLE IF NOT EXISTS purchase_books (
            book_id INT,
            user_id INT,

            INDEX user_id (user_id),
            INDEX book_id (book_id),

            FOREIGN KEY (user_id)
                REFERENCES users(id)
                ON DELETE CASCADE,

            FOREIGN KEY (book_id)
                REFERENCES books(id)
                ON DELETE CASCADE
        );
