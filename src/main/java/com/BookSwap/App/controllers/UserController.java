package com.BookSwap.App.controllers;

import com.BookSwap.App.bo.AddBookRequest;
import com.BookSwap.App.bo.CreateSwapRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.BookSwap.App.entities.Book;
import com.BookSwap.App.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add-book")
    public ResponseEntity<String> addBook(@RequestBody AddBookRequest addBookRequest) {
        userService.SaveBook(addBookRequest);
        return ResponseEntity.ok("Book Added Successfully");
    }

    @GetMapping("/all-books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = userService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @PostMapping("/swap")
    public ResponseEntity<String> swapBook(@RequestBody CreateSwapRequest createSwapRequest) {
        userService.swapBook(createSwapRequest);
        return ResponseEntity.ok("swap request created");
    }

}