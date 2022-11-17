package com.bridgelabz.employeepayrollapp.repository;


import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer> {
    //Custom query to get Employee of particular department
    @Query(value = "select * from employee_payroll_data where department = :department", nativeQuery = true)
    List<EmployeePayrollData> findByDepartment(String department);

    //Custom query to sort employee by its salary in ascending order
    @Query(value = "select * from employee_payroll_data group by salary order by salary asc", nativeQuery = true)
    List<EmployeePayrollData> sortedBySalary();
}
