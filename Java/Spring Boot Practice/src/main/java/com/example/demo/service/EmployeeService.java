package com.example.demo.service;

import com.example.demo.enitity.Employee;

import java.util.List;

public interface EmployeeService {
    public void saveEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public void deleteEmployee(Long id);
}
