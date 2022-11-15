package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class EmployeePayrollData {
    @Id
    @GeneratedValue

    private int employeeId;
    private String firstName;
    private String lastName;
    private long salary;
    private String profilePic;

    LocalDate date;


    //insert constructor
    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.firstName = employeePayrollDTO.getFirstName();
        this.lastName = employeePayrollDTO.getLastName();
        this.salary = employeePayrollDTO.getSalary();
        this.profilePic = employeePayrollDTO.getProfilePic();
        this.date = employeePayrollDTO.getDate();
    }

    //update constructor
    public EmployeePayrollData(int id, EmployeePayrollDTO employeePayrollDTO) {
        this.employeeId = id;
        this.firstName = employeePayrollDTO.getFirstName();
        this.lastName = employeePayrollDTO.getLastName();
        this.salary = employeePayrollDTO.getSalary();
        this.profilePic = employeePayrollDTO.getProfilePic();
        this.date = employeePayrollDTO.getDate();
    }


}
