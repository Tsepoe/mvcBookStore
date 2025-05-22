INSERT INTO authors (name, bio) VALUES
('George Orwell', 'George Orwell (1903 to 1950) was an English novelist, essayist, and critic, best known for his dystopian novel "1984" and the allegorical novella "Animal Farm".'),
('Jane Austen', 'Jane Austen (1775 to 1817) was an English novelist known for her six major novels, including "Pride and Prejudice", which critique the British landed gentry at the end of the 18th century.'),
('Mark Twain', 'Mark Twain (1835 to 1910), the pen name of Samuel Clemens, was an American writer, humorist, and lecturer known for "The Adventures of Tom Sawyer" and "Adventures of Huckleberry Finn".'),
('Toni Morrison', 'Toni Morrison (1931 to 2019) was an American novelist and Nobel Prize winner in Literature, celebrated for her works on African-American identity, including "Beloved" and "Song of Solomon".'),
('Haruki Murakami', 'Haruki Murakami (born 1949) is a contemporary Japanese writer whose works blend surrealism, magical realism, and themes of loneliness, including "Norwegian Wood" and "Kafka on the Shore".');

INSERT INTO books (title, author_id, isbn, publication_year) VALUES
('1984', 1, '9780451524935', 1949),
('Animal Farm', 1, '9780451526342', 1945),
('Pride and Prejudice', 2, '9780141439518', 1813),
('Emma', 2, '9780141439587', 1815),
('The Adventures of Tom Sawyer', 3, '9780486400778', 1876),
('Adventures of Huckleberry Finn', 3, '9780486280615', 1884),
('Beloved', 4, '9781400033416', 1987),
('Song of Solomon', 4, '9781400033423', 1977),
('Norwegian Wood', 5, '9780375704024', 1987),
('Kafka on the Shore', 5, '9781400079278', 2002);
