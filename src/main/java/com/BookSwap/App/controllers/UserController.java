package com.BookSwap.App.controllers;

import com.BookSwap.App.bo.AddBookRequest;
import com.BookSwap.App.bo.UpdateRequestStatus;
import com.BookSwap.App.config.JWTUtil;
import com.BookSwap.App.entities.RequestEntity;
import com.BookSwap.App.utils.UserDetailsUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.BookSwap.App.bo.CreateSwapRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.BookSwap.App.entities.BookEntity;
import com.BookSwap.App.services.user.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;
    private final JWTUtil jwtUtil;

    public UserController(UserService userService, JWTUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/add-book")
    public ResponseEntity<String> addBook(@RequestBody AddBookRequest addBookRequest) {
        userService.SaveBook(addBookRequest);
        return ResponseEntity.ok("Book Added Successfully");
    }

    @GetMapping("/get-books")
    public ResponseEntity<List<BookEntity>> getAllBooks() {
        List<BookEntity> books = userService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/get-sent-requests")
    public ResponseEntity<List<RequestEntity>> getSentRequests() {
        List<RequestEntity> requests = userService.getSentRequests(UserDetailsUtil.userDetails().getId());
        return ResponseEntity.ok(requests);
    }

    @GetMapping("/get-received-requests")
    public ResponseEntity<List<RequestEntity>> getReceivedRequests() {
        List<RequestEntity> requests = userService.getReceivedRequests(UserDetailsUtil.userDetails().getId());
        return ResponseEntity.ok(requests);
    }

    @PostMapping("/swap")
    public ResponseEntity<String> swapBook(@RequestBody CreateSwapRequest createSwapRequest) {
        userService.swapBook(createSwapRequest, UserDetailsUtil.userDetails().getId());
        return ResponseEntity.ok("swap request created");
    }

    @PutMapping("/update-request-status")
    public ResponseEntity<String> updateRequestStatus(@RequestParam Long requestID, @RequestBody UpdateRequestStatus updateRequestStatus) {
        try {
            userService.updateRequestStatus(requestID, updateRequestStatus);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Request Status Updated Successfully");
    }

    @GetMapping("/filter-by-category")
    public ResponseEntity<List<BookEntity>> getBooksByCategory(@RequestParam String category) {
        List<BookEntity> books = userService.getBooksByCategory(category);
        return ResponseEntity.ok().body(books);
    }
}