package com.BookSwap.App.entities;

import javax.persistence.*;

@Entity
public class Request_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private User_Entity sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private User_Entity receiver;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book_Entity book;

    public Book_Entity getBook() {
        return book;
    }

    public void setBook(Book_Entity book) {
        this.book = book;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User_Entity getSender() {
        return sender;
    }

    public void setSender(User_Entity sender) {
        this.sender = sender;
    }

    public User_Entity getReceiver() {
        return receiver;
    }

    public void setReceiver(User_Entity receiver) {
        this.receiver = receiver;
    }
}
