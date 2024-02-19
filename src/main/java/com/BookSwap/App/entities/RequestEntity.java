package com.BookSwap.App.entities;

import com.BookSwap.App.utils.enums.Status;

import javax.persistence.*;

@Entity
public class RequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private UserEntity sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private UserEntity receiver;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private BookEntity book;

    @Enumerated(EnumType.STRING)
    private Status status;

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserEntity getSender() {
        return sender;
    }



    public UserEntity getReceiver() {
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

    public void setSender(UserEntity sender) {
        this.sender = sender;
    }

    public void setReceiver(UserEntity receiver) {
        this.receiver = receiver;
    }
}
