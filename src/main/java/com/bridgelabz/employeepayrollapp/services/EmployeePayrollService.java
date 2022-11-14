package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
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
    private List<EmployeePayrollData> employeePayrollDataList = new ArrayList<EmployeePayrollData>();

    //Method to add data to the database
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
            employeePayrollDataList.set(id-1,updateEmployee);
            employeePayrollRepository.save(updateEmployee);
            return updateEmployee;
        } else {
            return null;
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
            employeePayrollDataList.set(id-1,updateEmployee);
            employeePayrollRepository.save(updateEmployee);
            return updateEmployee;
        } else {
            return null;
        }
    }

    @Override
    //Method to get data by its id in the database optional.ofNullable() method of java.util.Optional class in
    // Java is used to get an instance of this Optional class with the specified value of the specified type
    //  If the specified value is null, then this method returns an empty instance of the Optional class
    //id-1 is done because arraylist show element starting from 0
    public Optional<EmployeePayrollData> getById(int id) {

        return Optional.ofNullable(employeePayrollDataList.get(id - 1));
    }

    @Override
    //Method to get all the data in the database
    public List<EmployeePayrollData> getAll() {
        return employeePayrollDataList;
    }

    @Override
    //Method to delete data by its id
    public List<EmployeePayrollData> deleteById(int id) {
        employeePayrollRepository.deleteById(id);
        employeePayrollDataList.remove(id - 1);
        return employeePayrollRepository.findAll();
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
    //Count number of employees in database using id
    public String countIdInSavedList() {
        return "Number of employees in the List is : " + employeePayrollDataList.size();
    }

}
