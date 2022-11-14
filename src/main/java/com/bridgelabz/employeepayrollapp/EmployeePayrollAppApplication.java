package com.bridgelabz.employeepayrollapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//Using slf4j for logging in console
@Slf4j
public class EmployeePayrollAppApplication {

    public static void main(String[] args) {
        //SpringApplication.run Use to run the application with args and save it in the variable context
        // So we can access its environment property and print is using log.info
        ConfigurableApplicationContext context = SpringApplication.run(EmployeePayrollAppApplication.class, args);
        log.info("Employee payroll app started in {} Environment " + context.getEnvironment().getProperty("environment"));
        log.info("Employee payroll DB User is {} " + context.getEnvironment().getProperty("spring.datasource.username"));
    }

}
