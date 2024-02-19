package com.BookSwap.App.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Wishlist_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User_Entity user;
    @ManyToMany
    private Set<Book> book;
}
