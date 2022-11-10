package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.services.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/payroll")
public class EmployeePayrollController {

    @Autowired
    EmployeePayrollService employeePayrollService;

    @GetMapping("/get")
    public String display() {
        return employeePayrollService.display();
    }

}
