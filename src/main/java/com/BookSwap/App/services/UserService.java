package com.BookSwap.App.services;

import com.BookSwap.App.bo.AddBookRequest;
import com.BookSwap.App.bo.UpdateRequestStatus;
import com.BookSwap.App.entities.BookCategoryEntity;
import com.BookSwap.App.entities.Request_Entity;
import com.BookSwap.App.bo.CreateSwapRequest;
import com.BookSwap.App.entities.Book;
import com.BookSwap.App.utils.enums.Category;

import java.util.List;



public interface UserService {

    void SaveBook(AddBookRequest addBookRequest);
    List<Book> getAllBooks();
    List<Request_Entity> getAllRequests(Long userId);
    void swapBook(CreateSwapRequest createSwapRequest);

    void updateRequestStatus(Long requestID, UpdateRequestStatus updateRequestStatus);
    List<BookCategoryEntity> getBooksByCategory(Category category);

}
