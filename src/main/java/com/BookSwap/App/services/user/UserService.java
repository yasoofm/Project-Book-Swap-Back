package com.BookSwap.App.services.user;

import com.BookSwap.App.bo.AddBookRequest;
import com.BookSwap.App.bo.UpdateRequestStatus;
import com.BookSwap.App.entities.RequestEntity;
import com.BookSwap.App.bo.CreateSwapRequest;
import com.BookSwap.App.entities.BookEntity;

import java.util.List;
import java.util.Optional;


public interface UserService {

    void SaveBook(AddBookRequest addBookRequest);
    List<BookEntity> getAllBooks();
    List<RequestEntity> getSentRequests(Long userId);
    List<RequestEntity> getReceivedRequests(Long userId);
    void swapBook(CreateSwapRequest createSwapRequest, Long id);

    void updateRequestStatus(Long requestID, UpdateRequestStatus updateRequestStatus);
    List<BookEntity> getBooksByCategory(String category);

}
