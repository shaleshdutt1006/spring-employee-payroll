package com.bridgelabz.employeepayrollapp.dto;

public class ResponseDTO {
    private String message;
    private Object EmployeePayrollData;

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.EmployeePayrollData = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;


    }

    public Object getEmployeePayrollData() {
        return EmployeePayrollData;
    }

    public void setEmployeePayrollData(Object employeePayrollData) {
        EmployeePayrollData = employeePayrollData;
    }
}

