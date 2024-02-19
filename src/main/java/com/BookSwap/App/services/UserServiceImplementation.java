package com.BookSwap.App.services;

import com.BookSwap.App.bo.AddBookRequest;
import com.BookSwap.App.entities.Request_Entity;
import com.BookSwap.App.entities.User_Entity;
import com.BookSwap.App.repositories.RequestRepository;
import com.BookSwap.App.repositories.UserRepository;
import org.springframework.stereotype.Service;
import com.BookSwap.App.entities.Book_Entity;
import com.BookSwap.App.repositories.BookRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService{
    private final BookRepository bookRepository;
    private final RequestRepository requestRepository;
    private final UserRepository userRepository;

    public UserServiceImplementation(BookRepository bookRepository, RequestRepository requestRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.requestRepository = requestRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Book_Entity> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Request_Entity> getAllRequests(Long userId) {
        return requestRepository.findAll().stream()
                .filter(request -> request.getSender().getId() == userId)
                .collect(Collectors.toList());
    }

    @Override
    public void SaveBook(AddBookRequest addBookRequest) {
      Book_Entity book = new Book_Entity();
      book.setAuthor(addBookRequest.getAuthor());
      book.setCondition(addBookRequest.getCondition());
      book.setDescription(addBookRequest.getDescription());
      book.setIsbn(addBookRequest.getISBN());
      book.setTitle(addBookRequest.getTitle());
      bookRepository.save(book);
    }
    
}
