package com.example.demo.Controller;

import java.util.List;

import com.example.demo.Model.Employee;
import com.example.demo.Services.EmployeeServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok(employeeServices.getAllEmployees());
    }

    @GetMapping("/cafes/employees")
    public ResponseEntity<List<Employee>> getEmployees(){
        return ResponseEntity.ok(employeeServices.getEmployees());
    }

    @PostMapping("/cafe/employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeServices.addEmployee(employee));
    }

}
