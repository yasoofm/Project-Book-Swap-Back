package com.BookSwap.App.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class WishlistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
    @ManyToMany
    private Set<BookEntity> book;
}
