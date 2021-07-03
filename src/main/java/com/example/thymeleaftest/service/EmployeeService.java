package com.example.thymeleaftest.service;

import com.example.thymeleaftest.model.Employee;
import com.example.thymeleaftest.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee nou found with id " + id));
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
