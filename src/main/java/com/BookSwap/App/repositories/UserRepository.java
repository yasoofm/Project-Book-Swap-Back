package com.BookSwap.App.repositories;

import com.BookSwap.App.entities.User_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User_Entity, Long> {
    Optional<User_Entity> findByUsername(String username);
}
