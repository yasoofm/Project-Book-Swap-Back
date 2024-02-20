package com.BookSwap.App.repositories;

import com.BookSwap.App.entities.BookEntity;
import com.BookSwap.App.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    @Query(value = "SELECT * FROM Book_Entity r where r.category_id = :categoryId",nativeQuery = true)
    Optional<List<BookEntity>> findBooksByCategory(Long categoryId);
}
