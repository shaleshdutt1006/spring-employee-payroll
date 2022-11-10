package com.bridgelabz.employeepayrollapp.model;

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
    LocalDate startDate;

    public EmployeePayrollData(int employeeId, String firstName, String lastName, long salary, String profilePic, LocalDate startDate) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.profilePic = profilePic;
        this.startDate = startDate;
    }

    public EmployeePayrollData() {

    }

    public EmployeePayrollData(EmployeePayrollData employeePayrollData) {
        this.employeeId = employeePayrollData.employeeId;
        this.firstName = employeePayrollData.firstName;
        this.lastName = employeePayrollData.lastName;
        this.salary = employeePayrollData.salary;
        this.profilePic = employeePayrollData.profilePic;
        this.startDate = employeePayrollData.startDate;
    }

    public EmployeePayrollData(int id, EmployeePayrollData employeePayrollData) {
        this.employeeId = id;
        this.firstName = employeePayrollData.firstName;
        this.lastName = employeePayrollData.lastName;
        this.salary = employeePayrollData.salary;
        this.profilePic = employeePayrollData.profilePic;
        this.startDate = employeePayrollData.startDate;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
