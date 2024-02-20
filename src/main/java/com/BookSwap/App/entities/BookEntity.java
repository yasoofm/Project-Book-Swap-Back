package com.BookSwap.App.entities;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "ISBN", nullable = false)
    private long isbn;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String condition;

    @OneToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private BookCategoryEntity bookCategoryEntity;

    public BookCategoryEntity getBookCategoryEntity() {
        return bookCategoryEntity;
    }

    public void setBookCategoryEntity(BookCategoryEntity bookCategoryEntity) {
        this.bookCategoryEntity = bookCategoryEntity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
