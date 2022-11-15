package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class EmployeePayrollService implements IEmployeePayrollService {
    @Autowired
    EmployeePayrollRepository employeePayrollRepository;

    //Array List to get data by its id
    private List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();

    //Method to add data to the database and to employee list also
    @Override
    public EmployeePayrollData addData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData newEmployee = new EmployeePayrollData(employeePayrollDataList.size() + 1, employeePayrollDTO);
        employeePayrollDataList.add(newEmployee);
        employeePayrollRepository.save(newEmployee);
        return newEmployee;
    }

    @Override
    //Method to edit data in the database using optional
    public EmployeePayrollData updateData(int id, EmployeePayrollDTO employeePayrollDTO) {
        Optional<EmployeePayrollData> optional = employeePayrollRepository.findById(id);
        if (optional.isPresent()) {
            EmployeePayrollData updateEmployee = new EmployeePayrollData(id, employeePayrollDTO);
            employeePayrollDataList.set(id - 1, updateEmployee);
            employeePayrollRepository.save(updateEmployee);
            return updateEmployee;
        } else {
            throw new EmployeePayrollException("Employee not present in the list to update");
        }
    }

    @Override
    // Second method to update data using setter and getter methods
    public EmployeePayrollData EditData(int id, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData updateEmployee = employeePayrollRepository.findById(id).get();
        if (employeePayrollRepository.findById(id).isPresent()) {
            updateEmployee.setFirstName(employeePayrollDTO.getFirstName());
            updateEmployee.setLastName(employeePayrollDTO.getLastName());
            updateEmployee.setDate(employeePayrollDTO.getDate());
            updateEmployee.setEmployeeId(id);
            updateEmployee.setSalary(employeePayrollDTO.getSalary());
            updateEmployee.setProfilePic(employeePayrollDTO.getProfilePic());
            employeePayrollDataList.set(id - 1, updateEmployee);
            employeePayrollRepository.save(updateEmployee);
            return updateEmployee;
        } else {
            throw new EmployeePayrollException("Employee not present in the list to update");
        }
    }

    @Override
    //Method to get data by its id in the database if present otherwise throw custom exception of
    // the EmployeePayrollException class

    public EmployeePayrollData getById(int id) {
        return employeePayrollDataList.stream().
                filter(empData -> empData.getEmployeeId() == id).findFirst()
                .orElseThrow(() -> new EmployeePayrollException("Employee not found in the list"));
    }

    @Override
    //Method to get all the data in the database if it is empty then throw exception
    // otherwise give all employees
    public List<EmployeePayrollData> getAll() {
        if (!employeePayrollDataList.isEmpty()) {
            return employeePayrollDataList;
        } else throw new EmployeePayrollException("No Employee Present in the database");
    }

    @Override
    //Method to delete data by its id
    public List<EmployeePayrollData> deleteById(int id) {
        if (employeePayrollRepository.findById(id).isPresent()) {
            employeePayrollRepository.deleteById(id);
            employeePayrollDataList.remove(id - 1);
            return employeePayrollDataList;
        } else {
            throw new EmployeePayrollException("Id not present in the list to delete");
        }
    }

    @Override
    //Method to delete all the data in database
    public List<EmployeePayrollData> deleteAll() {
        employeePayrollDataList.clear();
        employeePayrollRepository.deleteAll();
        return employeePayrollRepository.findAll();
    }

    @Override
    //Count number of employees in database using id
    public String countByIdInRepository() {
        return "Number of employees in database are : " + employeePayrollRepository.count();
    }

    @Override
    //Count number of employees in database using their id
    public String countIdInSavedList() {
        if (employeePayrollDataList.isEmpty()) {
            throw new EmployeePayrollException("No Employees to count");
        } else {
            return "Number of employees in the List is : " + employeePayrollDataList.size();
        }
    }
}
