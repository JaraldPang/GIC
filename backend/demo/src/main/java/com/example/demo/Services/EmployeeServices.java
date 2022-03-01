package com.example.demo.Services;

import java.util.Comparator;
import java.util.List;

import com.example.demo.Model.Employee;
import com.example.demo.Repositories.EmployeeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServices {
    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }

    public List<Employee> getEmployees(){
        List<Employee> employees = employeeRepo.findAll();
        employees.sort(Comparator.comparing(Employee::getDaysWorked).reversed());
        return employees;
    }

    public Employee addEmployee(Employee employee){
        Employee current = employeeRepo.findByName(employee.getName());
        if (current != null){
            employeeRepo.deleteByName(employee.getName());
        }
        return employeeRepo.save(employee);
    }
}
