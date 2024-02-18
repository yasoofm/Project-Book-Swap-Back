package com.BookSwap.App.bo;

import com.BookSwap.App.entities.Book;

public class CreateSwapRequest {
    private Long sender;
    private Long receiver;
    private Long book;


    public Long getSender() {
        return sender;
    }

    public void setSender(Long sender) {
        this.sender = sender;
    }

    public Long getReceiver() {
        return receiver;
    }

    public void setReceiver(Long receiver) {
        this.receiver = receiver;
    }

    public Long getBook() {
        return book;
    }

    public void setBook(Long book) {
        this.book = book;
    }


}
