package com.BookSwap.App.repositories;

import com.BookSwap.App.entities.Category_Entity;
import com.BookSwap.App.utils.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category_Entity, Long> {
    Category_Entity findByCategory(Category category);
}
