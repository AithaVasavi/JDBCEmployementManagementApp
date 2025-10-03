# JDBCEmployementManagementApp  

🏢 **Java JDBC Employee Management App**  

📌 **Objective**  

A console-based Employee Management System built in Java using JDBC to connect with MySQL database.  
This project demonstrates CRUD operations (Create, Read, Update, Delete), JDBC best practices, exception handling, and transaction safety.  

---

🚀 **Features**  

1.➕ Add Employee (name, email, department, salary)  

2.📋 List All Employees  

3.🔍 View Employee by ID  

4.✏️ Update Employee Details  

5.❌ Delete Employee  

6.✅ Demonstrates:  

          6a.JDBC Connection with DriverManager  

          6b.Use of PreparedStatement (to prevent SQL injection)  

          6c.Handling SQLExceptions  

          6d.Use of try-with-resources for automatic closing  

          6e.DAO Pattern (EmployeeDAO)  

---

🛠️ **Tech Stack**  

Language: Java (JDK 17+)  

Database: MySQL  

JDBC Driver: MySQL Connector/J  

IDE: Eclipse (or IntelliJ / VS Code)  

---

📂 **Project Structure**  
EmployeeJDBCApp/  
 ├── db.properties                    
 ├── lib/                          
 │    └── mysql-connector-j-8.0.xx.jar  
 ├── src/  
 │    └── com/example/employee/  
 │         ├── DBConnection.java   
 │         ├── Employee.java      
 │         ├── EmployeeDAO.java    
 │         └── EmployeeApp.java    
 └── README.md  

 ---

 🗄️ **Database Setup**  

**Run these SQL commands in MySQL Workbench or terminal:**  
CREATE DATABASE employee_db;
USE employee_db;

CREATE TABLE employees (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) UNIQUE NOT NULL,
  department VARCHAR(50),
  salary DOUBLE
);

---

⚙️ **Configuration**  

Add a file db.properties (in project root or src/ depending on your code):  
db.url=jdbc:mysql://localhost:3306/employee_db?useSSL=false&serverTimezone=UTC  
db.user=root  
db.password=your_password_here  

---

▶️ **How to Run**  

**In Eclipse**  

1.Create project EmployeeJDBCApp.  

2.Add MySQL JDBC driver to Referenced Libraries.  

3.Place db.properties in project root (or src/ if using classpath load).  

4.Run EmployeeApp.java → choose options from the console menu.  

---

📝 **Sample Console Output**  
--- Employee App ---  
1. Add Employee  
2. List All Employees  
3. View Employee by ID  
4. Update Employee  
5. Delete Employee  
6. Exit  
Choose: 1  
NAME: Vasu  
EMAIL: vasu@gmail.com  
DEPARTMENT: AI  
SALARY: 35000  
Added: Employee{id=1, name='Vasu', email='vasu@gmail.com', dept='AI', salary=35000.00}  

--- Employee App ---   
Choose: 2  
Employee{id=1, name='Vasu', email='vasu@gmail.com', dept='AI', salary=35000.00}  

---

🎯 **Learning Outcomes**  

1.Understand JDBC API and database connectivity in Java  

2.Learn DAO design pattern for DB operations  

3.Implement CRUD operations with PreparedStatements  

4.Practice exception handling (SQLException)  

5.Work with MySQL + Java integration  

---

🔮 **Future Improvements**  

1.Add transaction management (commit/rollback)  

2.Build a Swing/JavaFX GUI for better usability  

3.Add authentication (login system for employees/admins)  

4.Migrate to Spring Boot + JPA/Hibernate for enterprise use  




