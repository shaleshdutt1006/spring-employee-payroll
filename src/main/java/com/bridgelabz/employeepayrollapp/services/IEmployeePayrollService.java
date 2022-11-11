package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

import java.util.List;
import java.util.Optional;

public interface IEmployeePayrollService {


    //Method to add data to the database
    EmployeePayrollData addData(EmployeePayrollDTO employeePayrollDTO);

    //Method to edit data in the database using optional
    EmployeePayrollData updateData(int id, EmployeePayrollDTO employeePayrollDTO);

    // Second method to update data using setter and getter methods
    EmployeePayrollData EditData(int id, EmployeePayrollDTO employeePayrollDTO);

    //Method to get data by its id in the database
    Optional<EmployeePayrollData> getById(int id);

    List<EmployeePayrollData> getAll();


}
