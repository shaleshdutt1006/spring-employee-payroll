package com.bridgelabz.employeepayrollapp.exception;

//Custom Exception for EmployeePayrollApp
public class EmployeePayrollException extends RuntimeException {

    public EmployeePayrollException(String message) {
        //super keyword used to give message to the runtime Exception class
        super(message);
    }
}
