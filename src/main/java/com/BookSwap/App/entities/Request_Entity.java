package com.BookSwap.App.entities;

import com.BookSwap.App.utils.enums.Status;

import javax.persistence.*;

@Entity
public class Request_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private User_Entity sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private User_Entity receiver;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
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



    public User_Entity getReceiver() {
        return receiver;
    }



    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public void setSender(User_Entity sender) {
        this.sender = sender;
    }

    public void setReceiver(User_Entity receiver) {
        this.receiver = receiver;
    }
}
