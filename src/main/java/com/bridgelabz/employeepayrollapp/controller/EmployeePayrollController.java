package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.services.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payroll")
public class EmployeePayrollController {

    @Autowired
    IEmployeePayrollService employeePayrollService;

    //Method for adding data in database
    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = employeePayrollService.addData(employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Data added successfully ", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }


    //Method to update data in database
    @PutMapping("/update/{Id}")
    public ResponseEntity<ResponseDTO> updateData(@PathVariable int Id, @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData updatedEmployee = employeePayrollService.updateData(Id, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated employee data successfully", updatedEmployee);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }

    //Second Method to update data in database
    @PutMapping("/edit/{Id}")
    public ResponseEntity<ResponseDTO> EditData(@PathVariable int Id, @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData updatedEmployee = employeePayrollService.EditData(Id, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated employee data successfully", updatedEmployee);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }

    // Method to get data by its Id here we use Optional in return because if Id present
    // then it return data otherwise return null
    @GetMapping("/getId/{Id}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable(value = "Id") int Id) {
        Optional<EmployeePayrollData> updatedEmployee = employeePayrollService.getById(Id);
        ResponseDTO responseDTO = new ResponseDTO("Get call Id successfully", updatedEmployee);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //Method to get all the data in database
    @GetMapping("/get-all")
    public List<EmployeePayrollData> getAll() {
        return employeePayrollService.getAll();
    }

    //Method to delete data by its employeeId
    @DeleteMapping("delete/{Id}")
    public List<EmployeePayrollData> deleteBYId(@PathVariable(value = "Id") int Id) {
        return employeePayrollService.deleteById(Id);
    }

    //Method to delete all data
    @DeleteMapping("/delete-all")
    public List<EmployeePayrollData> deleteAll() {
        return employeePayrollService.deleteAll();
    }

    //Count number of employees in database using id
    @GetMapping("/countInRepo")
    public String countById() {
        return employeePayrollService.countByIdInRepository();
    }

    //Count number of employees in saved arraylist
    @GetMapping("/countInList")
    public String countIdInSavedList() {
        return employeePayrollService.countIdInSavedList();
    }
}
