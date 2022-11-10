package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.services.EmployeePayrollService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/payroll")
public class EmployeePayrollController {

    @Autowired
    EmployeePayrollService employeePayrollService;

    //Method for adding data in database
    @PutMapping("/add")
    public EmployeePayrollData addData(@RequestBody EmployeePayrollData employeePayrollData) {
        return employeePayrollService.addData(employeePayrollData);
    }

    //Method to update data in database
    @PostMapping("/update/{Id}")
    public EmployeePayrollData updateData(@PathVariable(value = "Id") int Id, @RequestBody EmployeePayrollData employeePayrollData) {
        return employeePayrollService.updateData(Id, employeePayrollData);
    }

    // Method to get data by its Id here we use Optional in return because if Id present
    // then it return data otherwise return null
    @GetMapping("/getId/{Id}")
    public Optional<EmployeePayrollData> getById(@PathVariable(value = "Id") int Id) {
        return employeePayrollService.getById(Id);
    }

    //Method to get all the data in database
    @GetMapping("/getall")
    public List<EmployeePayrollData> getAll() {
        return employeePayrollService.getAll();
    }

    //Method to delete data by its Id
    @DeleteMapping("delete/{Id}")
    public List<EmployeePayrollData> deleteBYId(@PathVariable(value = "Id") int Id) {
        return employeePayrollService.deleteById(Id);

    }

    //Method to delete all data
    @DeleteMapping("/deleteall")
    public List<EmployeePayrollData> deleteAll() {
        return employeePayrollService.deleteAll();
    }

    //Count number of employees in database using id
    @GetMapping("/count")
    public String countById() {
       return employeePayrollService.countById();
    }
}
