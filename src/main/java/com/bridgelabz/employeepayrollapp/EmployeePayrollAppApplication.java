package com.bridgelabz.employeepayrollapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


//Using slf4j for logging in console
@Slf4j
@SpringBootApplication


public class EmployeePayrollAppApplication {
//Here context is used to store the configuration of SpringApplication which run with various argument
// from that we are able to get environment and database name
    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(EmployeePayrollAppApplication.class, args);
        log.info("Employee payroll app started in {} Environment " + context.getEnvironment().getProperty("environment"));
        log.info("Employee payroll DB User is {} " + context.getEnvironment().getProperty("spring.datasource.username"));

    }

}
