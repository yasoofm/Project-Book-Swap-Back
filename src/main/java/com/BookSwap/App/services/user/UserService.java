package com.BookSwap.App.services.user;

import com.BookSwap.App.bo.AddBookRequest;
import com.BookSwap.App.bo.UpdateRequestStatus;
import com.BookSwap.App.entities.BookCategoryEntity;
import com.BookSwap.App.entities.RequestEntity;
import com.BookSwap.App.bo.CreateSwapRequest;
import com.BookSwap.App.entities.BookEntity;
import com.BookSwap.App.utils.enums.Category;

import java.util.List;



public interface UserService {

    void SaveBook(AddBookRequest addBookRequest);
    List<BookEntity> getAllBooks();
    List<RequestEntity> getAllRequests(Long userId);
    void swapBook(CreateSwapRequest createSwapRequest);

    void updateRequestStatus(Long requestID, UpdateRequestStatus updateRequestStatus);
    List<BookCategoryEntity> getBooksByCategory(Category category);

}
