package com.BookSwap.App.repositories;

import com.BookSwap.App.entities.BookCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategoryEntity, Long> {
}