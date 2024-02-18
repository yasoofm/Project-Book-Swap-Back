package com.BookSwap.App.controllers;

import com.BookSwap.App.bo.AddBookRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.BookSwap.App.entities.Book_Entity;
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

    @PostMapping("/add-books")
    public ResponseEntity<String> addBook(@RequestBody AddBookRequest addBookRequest) {
        userService.SaveBook(addBookRequest);
        return ResponseEntity.ok("Book Added Successfully");
    }
    @GetMapping("/all-books")
    public ResponseEntity<List<Book_Entity>> getAllBooks () {
        List<Book_Entity> books = userService.getAllBooks();
        return ResponseEntity.ok(books);
    }

}