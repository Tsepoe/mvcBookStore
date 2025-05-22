package com.example.bookstore.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.bookstore.model.book;

@Repository
public class bookDao {
    private final JdbcTemplate jdbcTemplate;

    public bookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<book> bookRowMapper = (rs, rowNum) -> {
        book book = new book();
        book.setId(rs.getLong("id"));
        book.setTitle(rs.getString("title"));
        book.setAuthorId(rs.getLong("author_id"));
        book.setAuthorName(rs.getString("author_name")); 
        book.setIsbn(rs.getString("isbn"));
        book.setPublicationYear(rs.getInt("publication_year"));
        return book;
    };

    
    public List<book> findAll() {
        return jdbcTemplate.query(
            "SELECT b.*, a.name AS author_name " +
            "FROM books b " +
            "JOIN authors a ON b.author_id = a.id",
            bookRowMapper
        );
    }

    
    public List<book> findByAuthorId(Long authorId) {
        return jdbcTemplate.query(
            "SELECT b.*, a.name AS author_name " +
            "FROM books b " +
            "JOIN authors a ON b.author_id = a.id " +
            "WHERE b.author_id = ?", 
            bookRowMapper, 
            authorId
        );
    }

    
    public Optional<book> findById(Long id) {
        List<book> books = jdbcTemplate.query(
            "SELECT b.*, a.name AS author_name " +
            "FROM books b " +
            "JOIN authors a ON b.author_id = a.id " +
            "WHERE b.id = ?", 
            bookRowMapper, 
            id
        );
        return books.stream().findFirst();
    }

    
    public void save(book book) {
        if (book.getId() == null) {
            jdbcTemplate.update(
                "INSERT INTO books(title, author_id, isbn, publication_year) VALUES(?, ?, ?, ?)",
                book.getTitle(),
                book.getAuthorId(),
                book.getIsbn(),
                book.getPublicationYear()
            );
        } else {
            jdbcTemplate.update(
                "UPDATE books SET title = ?, author_id = ?, isbn = ?, publication_year = ? WHERE id = ?",
                book.getTitle(),
                book.getAuthorId(),
                book.getIsbn(),
                book.getPublicationYear(),
                book.getId()
            );
        }
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM books WHERE id = ?", id);
    }
}