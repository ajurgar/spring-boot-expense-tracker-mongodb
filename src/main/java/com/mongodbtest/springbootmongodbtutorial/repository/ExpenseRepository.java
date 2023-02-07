package com.mongodbtest.springbootmongodbtutorial.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.mongodbtest.springbootmongodbtutorial.model.Expense;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;


public interface ExpenseRepository extends MongoRepository<Expense, String> {
    @Query("{'name': ?0}")
    Optional<Expense> findByName(String name);
}
