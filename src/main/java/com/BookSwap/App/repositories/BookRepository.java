package com.BookSwap.App.repositories;

import com.BookSwap.App.entities.Book_Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book_Entity, Long> {
}
