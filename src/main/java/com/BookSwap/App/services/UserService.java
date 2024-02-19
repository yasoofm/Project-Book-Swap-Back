package com.BookSwap.App.services;

import com.BookSwap.App.bo.AddBookRequest;
import com.BookSwap.App.entities.Request_Entity;
import com.BookSwap.App.bo.CreateSwapRequest;
import com.BookSwap.App.entities.Book;

import java.util.List;



public interface UserService {

    void SaveBook(AddBookRequest addBookRequest);
    List<Book> getAllBooks();
    List<Request_Entity> getAllRequests(Long userId);
    void swapBook(CreateSwapRequest createSwapRequest);
}
