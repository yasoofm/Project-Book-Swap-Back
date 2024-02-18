package com.BookSwap.App.entities;

import com.BookSwap.App.utils.enums.Category;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Category_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToMany
    private Set<Book_Entity> book;

    @Enumerated(EnumType.STRING)
    private Category category;
}
