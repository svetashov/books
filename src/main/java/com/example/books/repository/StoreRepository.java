package com.example.books.repository;

import com.example.books.entity.Store;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StoreRepository extends CrudRepository<Store, Long> {
    Optional<Store> findByName(String name);
}
