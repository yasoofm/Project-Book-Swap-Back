package com.BookSwap.App.repositories;

import com.BookSwap.App.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, java.lang.Long> {
}
