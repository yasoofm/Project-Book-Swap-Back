package com.BookSwap.App.repositories;

import com.BookSwap.App.entities.User_Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User_Entity, Long> {
}
