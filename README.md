# Employee-Payroll







UseCase1-Create a Employee Payroll Spring
Project to cater to REST Request from
Employee Payroll UI - Here we will reuse the Employee Payroll Frontend UI
we have already developed
- Instead of making REST call to JSONServer will now
make server calls to Employee Payroll Spring App
- Also test the REST API using CURL Commandsista 

















USeCase2-Create a Rest Controller to
demonstrate the various HTTP Methods
- Before starting set application.properties to set
properties of MySQL Driver and MySQL Credentials
- Test the REST Calls using CURL.
- At this stage the interest is to establish the
connectivity and ensure data is transmitted in REST
Calls








UseCase 3-Introducing DTO and Model to
Employee Payroll App - Note that we have kept the DTO and Model fairly
simplistic with only Name and Salary
- This is because we are still in the setup of the
Layers and once set we would make Employee
Payroll as full -fledged Object for Front End to make REST Call.
- Currently we will do CURL Call to ensure











UseCase 4-Introducing Services Layer in
Employee Payroll App - Note that Controller in UC1 was creating the
Model and returning the Model on the REST Calls.
This is the job of services layer to manage the
Model.
- Autowired Annotation will be used to do
Dependency Injection of the Services Object to
the Controller.












UseCase 5-Ability for the Services Layer to
store the Employee Payroll Data
- Note that Services Layer is not storing, updating
or deleting Employee Payroll Data in UC 2.
- In this use case the Services Layer will store this
Data in a Memory as a List. As we go further
down we will persist this data in DB.
