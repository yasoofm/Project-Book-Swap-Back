package com.BookSwap.App.entities;

import com.BookSwap.App.utils.enums.Role;

import javax.persistence.*;

@Entity
public class RoleEntity {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private Role title;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Role getTitle() {
        return title;
    }

    public void setTitle(Role title) {
        this.title = title;
    }
}
