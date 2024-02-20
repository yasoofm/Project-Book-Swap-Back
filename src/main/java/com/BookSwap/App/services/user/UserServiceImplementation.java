package com.BookSwap.App.services.user;

import com.BookSwap.App.bo.AddBookRequest;
import com.BookSwap.App.bo.CreateSwapRequest;
import com.BookSwap.App.bo.UpdateRequestStatus;
import com.BookSwap.App.entities.BookEntity;
import com.BookSwap.App.entities.BookCategoryEntity;
import com.BookSwap.App.entities.RequestEntity;
import com.BookSwap.App.entities.UserEntity;
import com.BookSwap.App.repositories.*;
import com.BookSwap.App.utils.enums.Category;
import com.BookSwap.App.utils.enums.Status;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {
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
    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<RequestEntity> getSentRequests(Long userId) {
        return requestRepository.findAll().stream()
                .filter(request -> request.getSender().getId() == userId)
                .collect(Collectors.toList());
    }
    @Override
    public List<RequestEntity> getReceivedRequests(Long userId) {
        return requestRepository.findAll().stream()
                .filter(request -> request.getReceiver().getId() == userId)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void SaveBook(AddBookRequest addBookRequest) {
      BookEntity book = new BookEntity();
      book.setAuthor(addBookRequest.getAuthor());
      book.setCondition(addBookRequest.getCondition());
      book.setDescription(addBookRequest.getDescription());
      book.setIsbn(addBookRequest.getISBN());
      book.setTitle(addBookRequest.getTitle());

      BookCategoryEntity bookCategoryEntity = new BookCategoryEntity();
      bookCategoryEntity.setBook(book);
      bookCategoryEntity.setCategoryEntity(categoryRepository.findByCategory(Category.valueOf(addBookRequest.getCategory())));

      book.setBookCategoryEntity(bookCategoryEntity);

      bookRepository.save(book);
      bookCategoryRepository.save(bookCategoryEntity);
    }
  
    @Override
    public void swapBook(CreateSwapRequest createSwapRequest, Long senderId) {
        UserEntity sender = userRepository.findById(senderId).orElseThrow();
        UserEntity receiver = userRepository.findById(createSwapRequest.getReceiver()).orElseThrow();
        BookEntity book = bookRepository.findById(createSwapRequest.getBook()).orElseThrow();
        RequestEntity swapRequest = new RequestEntity();
        swapRequest.setSender(sender);
        swapRequest.setReceiver(receiver);
        swapRequest.setBook(book);
        swapRequest.setStatus(Status.PENDING);
        requestRepository.save(swapRequest);
    }
    @Override
    public void updateRequestStatus(Long requestID, UpdateRequestStatus updateRequestStatus){
        RequestEntity requestEntity = requestRepository.findById(requestID)
                .orElseThrow(() -> new RuntimeException("Request with this id not found: " + requestID));
        requestEntity.setStatus(Status.valueOf(updateRequestStatus.getStatus()));
        requestRepository.save(requestEntity);
    }
    @Override
    public List<BookEntity> getBooksByCategory(String category) {
        return bookCategoryRepository.findAll().stream()
                .filter(categoryEntity -> categoryEntity.getCategoryEntity().getCategory().name().equals(category))
                .map(BookCategoryEntity::getBook)
                .collect(Collectors.toList());
    }

}
