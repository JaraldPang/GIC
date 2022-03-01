package com.example.demo.Repositories;

import java.util.List;

import com.example.demo.Model.Employee;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepo extends MongoRepository<Employee, String>{
    List<Employee> findAll();
    Employee findByName(String name);
    Employee deleteByName(String name);
}
