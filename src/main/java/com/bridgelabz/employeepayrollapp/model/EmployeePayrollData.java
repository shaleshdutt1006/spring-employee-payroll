package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity

public class EmployeePayrollData {
    @Id
    @GeneratedValue

    private int employeeId;
    private String firstName;
    private String lastName;
    private long salary;
    private String profilePic;

    LocalDate date;

    public EmployeePayrollData() {

    }

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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
