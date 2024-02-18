package com.BookSwap.App.services;

import com.BookSwap.App.bo.AddBookRequest;
import org.springframework.stereotype.Service;
import com.BookSwap.App.entities.Book_Entity;
import com.BookSwap.App.repositories.BookRepository;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService{
    private final BookRepository bookRepository;

    public UserServiceImplementation(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book_Entity> getAllBooks() {
        return bookRepository.findAll();

    }
  
    @Override
    public void SaveBook(AddBookRequest addBookRequest) {
      
    }
    
}
