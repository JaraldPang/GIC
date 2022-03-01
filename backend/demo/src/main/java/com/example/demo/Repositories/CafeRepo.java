package com.example.demo.Repositories;

import java.util.List;

import com.example.demo.Model.Cafe;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CafeRepo extends MongoRepository<Cafe, String> {
    @Query("{'location': ?0}")
    List<Cafe> findByLocation(String location);
    @Query("{'name': ?0}")
    Cafe findByName(String name);
    void deleteByName(String Name);
}
