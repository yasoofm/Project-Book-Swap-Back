package com.BookSwap.App.controllers;

import com.BookSwap.App.bo.AddBookRequest;
import com.BookSwap.App.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
