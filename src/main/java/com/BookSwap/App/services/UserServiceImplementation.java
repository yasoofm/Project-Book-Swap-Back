package com.BookSwap.App.services;

import com.BookSwap.App.bo.AddBookRequest;
import com.BookSwap.App.bo.CreateSwapRequest;
import com.BookSwap.App.entities.Request_Entity;
import com.BookSwap.App.entities.User_Entity;
import com.BookSwap.App.repositories.RequestRepository;
import com.BookSwap.App.repositories.UserRepository;
import com.BookSwap.App.utils.enums.Status;
import org.springframework.stereotype.Service;
import com.BookSwap.App.entities.Book;
import com.BookSwap.App.repositories.BookRepository;
import java.util.List;

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
    public List<Book> getAllBooks() {
        return bookRepository.findAll();

    }


    @Override
    public void SaveBook(AddBookRequest addBookRequest) {
      Book book = new Book();
      book.setAuthor(addBookRequest.getAuthor());
      book.setCondition(addBookRequest.getCondition());
      book.setDescription(addBookRequest.getDescription());
      book.setIsbn(addBookRequest.getISBN());
      book.setTitle(addBookRequest.getTitle());
      bookRepository.save(book);
    }
    @Override
    public void swapBook(CreateSwapRequest createSwapRequest) {
        User_Entity sender = userRepository.findById(createSwapRequest.getSender()).orElseThrow();
        User_Entity receiver = userRepository.findById(createSwapRequest.getReceiver()).orElseThrow();
        Book book = bookRepository.findById(createSwapRequest.getBook()).orElseThrow();
        Request_Entity swapRequest = new Request_Entity();
        swapRequest.setSender(sender);
        swapRequest.setReceiver(receiver);
        swapRequest.setBook(book);
        swapRequest.setStatus(Status.PENDING);
    }


    
}
