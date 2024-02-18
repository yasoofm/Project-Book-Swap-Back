package com.BookSwap.App.services;

import com.BookSwap.App.entities.Book_Entity;

import java.util.List;

public interface UserService {
    List<Book_Entity> getAllBooks();
}
