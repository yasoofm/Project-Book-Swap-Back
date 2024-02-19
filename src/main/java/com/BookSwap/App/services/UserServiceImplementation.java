package com.BookSwap.App.services;

import com.BookSwap.App.bo.AddBookRequest;
import com.BookSwap.App.bo.CreateSwapRequest;
import com.BookSwap.App.bo.UpdateRequestStatus;
import com.BookSwap.App.entities.*;
import com.BookSwap.App.repositories.*;
import com.BookSwap.App.utils.enums.Category;
import com.BookSwap.App.utils.enums.Status;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService{
    private final BookRepository bookRepository;
    private final RequestRepository requestRepository;
    private final UserRepository userRepository;

    private final BookCategoryRepository bookCategoryRepository;
    private final CategoryRepository categoryRepository;

    public UserServiceImplementation(BookRepository bookRepository, RequestRepository requestRepository, UserRepository userRepository, BookCategoryRepository bookCategoryRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.requestRepository = requestRepository;
        this.userRepository = userRepository;
        this.bookCategoryRepository = bookCategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Book> getAllBooks() {
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
    @Override
    public void updateRequestStatus(Long requestID, UpdateRequestStatus updateRequestStatus){
        Request_Entity requestEntity = requestRepository.findById(requestID)
                .orElseThrow(() -> new RuntimeException("Request with this id not found: " + requestID));
        requestEntity.setStatus(Status.valueOf(updateRequestStatus.getStatus()));
        requestRepository.save(requestEntity);

    }
    @Override
    public List<BookCategoryEntity> getBooksByCategory(Category category) {
        return bookCategoryRepository.findAll().stream()
                .filter(categoryEntity -> categoryEntity.getCategoryEntity().getCategory() == category)
                .collect(Collectors.toList());
    }



}
