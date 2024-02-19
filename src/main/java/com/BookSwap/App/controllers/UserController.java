package com.BookSwap.App.controllers;

import com.BookSwap.App.bo.AddBookRequest;
import com.BookSwap.App.entities.Request_Entity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.BookSwap.App.entities.Book_Entity;
import com.BookSwap.App.services.UserService;

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
    public ResponseEntity<List<Book_Entity>> getAllBooks () {
        List<Book_Entity> books = userService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/get-requests")
    public ResponseEntity<List<Request_Entity>> getRequests(@RequestParam Long id){
        List<Request_Entity> requests = userService.getAllRequests(id);
        return ResponseEntity.ok(requests);
    }
}