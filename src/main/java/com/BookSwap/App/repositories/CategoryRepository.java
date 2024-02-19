package com.BookSwap.App.repositories;

import com.BookSwap.App.entities.CategoryEntity;
import com.BookSwap.App.utils.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity findByCategory(Category category);
}
