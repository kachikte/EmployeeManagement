THIS IS THE README FILE THAT DESCRIBES THE OPERATION OF THE "Employee Management" PROJECT

1. Clone the repository using the command - git clone https://github.com/kachikte/EmployeeManagement.git or git@github.com:kachikte/EmployeeManagement.git and checkout into main branch
2. run - mvn clean
3. run - mvn install
4. Make sure the dependencies have been resolved
5. Run the application from your IDE
6. Make sure the project is running on localhost:7070
The APIs should be called in the following order:

a. addEmployees - to add an employee.

b. AddFile - The ID from the Employee response above should be passed as a path variable for this API call. The body should be a form-data, with key value - file.

c. getEmployee - to get details of an employee by Id

d. updateEmployees - to update an employee

e. deleteEmployee - to delete a particular employees records by ID

f. getEmployees - to get all employees details.


