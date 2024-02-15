package com.BookSwap.App.entities;

import javax.persistence.*;

@Entity
public class Wishlist_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private User_Entity user;
    @ManyToMany
    @JoinColumn(nullable = false)
    private Book_Entity book;
}
