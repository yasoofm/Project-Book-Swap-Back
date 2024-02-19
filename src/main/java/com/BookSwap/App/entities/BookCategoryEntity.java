package com.BookSwap.App.entities;

import javax.persistence.*;

@Entity
@Table(name = "book_category")
public class BookCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category_Entity categoryEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Category_Entity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(Category_Entity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }
}
