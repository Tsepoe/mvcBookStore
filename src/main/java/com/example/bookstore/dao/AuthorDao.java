package com.example.bookstore.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.bookstore.model.Author;

@Repository
public class AuthorDao {
    private final JdbcTemplate jdbcTemplate;

    public AuthorDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Author> authorRowMapper = (rs, rowNum) -> {
        Author author = new Author();
        author.setId(rs.getLong("id"));
        author.setName(rs.getString("name"));
        author.setBio(rs.getString("bio"));
        return author;
    };

    public List<Author> findAll() {
        return jdbcTemplate.query("SELECT * FROM authors", authorRowMapper);
    }

    public Optional<Author> findById(Long id) {
        List<Author> authors = jdbcTemplate.query(
            "SELECT * FROM authors WHERE id = ?", 
            authorRowMapper, 
            id
        );
        return authors.stream().findFirst();
    }

    public void save(Author author) {
        if (author.getId() == null) {
            jdbcTemplate.update(
                "INSERT INTO authors(name, bio) VALUES(?, ?)",
                author.getName(),
                author.getBio()
            );
        } else {
            jdbcTemplate.update(
                "UPDATE authors SET name = ?, bio = ? WHERE id = ?",
                author.getName(),
                author.getBio(),
                author.getId()
            );
        }
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM authors WHERE id = ?", id);
    }
}
