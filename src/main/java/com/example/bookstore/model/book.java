package com.example.bookstore.model;

public class book {

    private Long id;
    private String title;
    private String authorName;
    private Long authorId;
    private String isbn;
    private int publicationYear;

    public book(){}

    public book(Long id, String title, String authorName,long authorId, String isbn, int publicationYear ){
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.authorId = authorId;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

  

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authorId=" + authorId +
                ", isbn='" + isbn + '\'' +
                ", publicationYear='" + publicationYear + '\'' +
                '}';
    }



}
