package com.BookSwap.App.services;

import com.BookSwap.App.bo.AddBookRequest;
import com.BookSwap.App.bo.CreateSwapRequest;
import com.BookSwap.App.entities.Book;

import java.util.List;



public interface UserService {

    void SaveBook(AddBookRequest addBookRequest);
    List<Book> getAllBooks();

    void swapBook(CreateSwapRequest createSwapRequest);
}
