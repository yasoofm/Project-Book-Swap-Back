package com.BookSwap.App.entities;

import com.BookSwap.App.utils.enums.Category;
import javax.persistence.*;
import java.util.Set;

@Entity
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToMany
    private Set<BookEntity> book;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<BookEntity> getBook() {
        return book;
    }

    public void setBook(Set<BookEntity> book) {
        this.book = book;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Enumerated(EnumType.STRING)
    private Category category;
}
