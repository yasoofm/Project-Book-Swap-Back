package com.BookSwap.App.services.user;

import com.BookSwap.App.bo.bookrequest.CreateBookRequest;
import com.BookSwap.App.bo.bookrequest.UpdateRequestStatus;
import com.BookSwap.App.entities.RequestEntity;
import com.BookSwap.App.bo.bookswap.CreateSwapRequest;
import com.BookSwap.App.entities.BookEntity;

import java.util.List;


public interface UserService {

    void SaveBook(CreateBookRequest createBookRequest);
    List<BookEntity> getAllBooks();
    List<RequestEntity> getSentRequests(Long userId);
    List<RequestEntity> getReceivedRequests(Long userId);
    void swapBook(CreateSwapRequest createSwapRequest, Long id);

    void updateRequestStatus(Long requestID, UpdateRequestStatus updateRequestStatus);
    List<BookEntity> getBooksByCategory(String category);

}
