package com.BookSwap.App.services;

import com.BookSwap.App.bo.AddBookRequest;
import com.BookSwap.App.entities.Book_Entity;
import java.util.List;



public interface UserService {

    void SaveBook(AddBookRequest addBookRequest);
    List<Book_Entity> getAllBooks();
}
