package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeePayrollService {
    @Autowired
    EmployeePayrollRepository employeePayrollRepository;

    //Method to add data to the database
    public EmployeePayrollData addData(EmployeePayrollData employeePayrollData) {
        return employeePayrollRepository.save(new EmployeePayrollData(employeePayrollData));
    }

    //Method to edit data in the database using optional
    public EmployeePayrollData updateData(int id, EmployeePayrollData employeePayrollData) {
        Optional<EmployeePayrollData> optional = employeePayrollRepository.findById(id);
        if (optional.isPresent()) {
            EmployeePayrollData employeePayrollData1 = new EmployeePayrollData(id, employeePayrollData);
            employeePayrollRepository.save(employeePayrollData1);
            return employeePayrollData1;
        } else {
            return null;
        }
    }

    //Method to get data by its id in the database
    public Optional<EmployeePayrollData> getById(int id) {
        return employeePayrollRepository.findById(id);
    }

    //Method to get all the data in the database
    public List<EmployeePayrollData> getAll() {
        return employeePayrollRepository.findAll();
    }

    //Method to delete data by its id
    public List<EmployeePayrollData> deleteById(int id) {
        employeePayrollRepository.deleteById(id);
        return employeePayrollRepository.findAll();
    }

    //Method to delete all the data in database
    public List<EmployeePayrollData> deleteAll() {
        employeePayrollRepository.deleteAll();
        return employeePayrollRepository.findAll();
    }

    //Count number of employees in database using id
    public String countById() {
       return "Number of employees in database are : "+ employeePayrollRepository.count();
    }
}
