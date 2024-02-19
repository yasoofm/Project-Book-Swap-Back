package com.BookSwap.App.repositories;

import com.BookSwap.App.entities.Request_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request_Entity, Long> {

}
