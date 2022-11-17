package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {


    //Method to add data to the database
    EmployeePayrollData addData(EmployeePayrollDTO employeePayrollDTO);

    //Method to edit data in the database using optional
    EmployeePayrollData updateData(int id, EmployeePayrollDTO employeePayrollDTO);

    // Second method to update data using setter and getter methods
    EmployeePayrollData EditData(int id, EmployeePayrollDTO employeePayrollDTO);

    // Method to find employee by its department
    List<EmployeePayrollData> findEmployeeByDepartment(String department);

    //Method to sort Employee by its salary
    List<EmployeePayrollData> sortedBySalary();

    //Method to get data by its id in the database
    EmployeePayrollData getById(int id);

    List<EmployeePayrollData> getAll();


    //Method to delete data by its id
    List<EmployeePayrollData> deleteById(int id);

    //Method to delete all the data in database
    List<EmployeePayrollData> deleteAll();

    //Count number of employees in database using employeeId
    String countByIdInRepository();

    //Count number of employees in database using employeeId
    String countIdInSavedList();
}
