package com.BookSwap.App.entities;

import com.BookSwap.App.utils.enums.Category;

import javax.persistence.*;

@Entity
public class Category_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToMany
    @JoinColumn(nullable = false)
    private Book_Entity book;

    private Category category;
}
