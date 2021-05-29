package com.sayitfast.important_info.services;

import com.sayitfast.important_info.models.Employee;
import com.sayitfast.important_info.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //Return list of employees
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    //SAve new employee
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    //get by id
    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    //Get employees by keyword
    public List<Employee> findByKeyword(String keyword) {
        return employeeRepository.findByKeyword(keyword);

    }
}
