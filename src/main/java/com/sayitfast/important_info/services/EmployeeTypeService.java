package com.sayitfast.important_info.services;

import com.sayitfast.important_info.models.EmployeeType;
import com.sayitfast.important_info.repositories.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTypeService {
    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;

    //Return list of countries
    public List<EmployeeType> getEmployeeTypes() {
        return employeeTypeRepository.findAll();
    }

    //SAve new EmployeeType
    public void save(EmployeeType employeeType) {
        employeeTypeRepository.save(employeeType);
    }

    //get by id
    public Optional<EmployeeType> findById(int id) {
        return employeeTypeRepository.findById(id);
    }

    public void delete(Integer id) {
        employeeTypeRepository.deleteById(id);
    }

}
