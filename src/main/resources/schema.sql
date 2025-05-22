
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS authors;

-- Authors table
CREATE TABLE authors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    bio TEXT
);

-- Books table (with foreign key to authors)
CREATE TABLE books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author_id BIGINT NOT NULL,
    isbn VARCHAR(20),
    publication_year VARCHAR(4),
    FOREIGN KEY (author_id) REFERENCES authors(id) ON DELETE CASCADE
);