package com.BookSwap.App.bo;

public class CreateSwapRequest {

    private Long receiver;
    private Long book;

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
