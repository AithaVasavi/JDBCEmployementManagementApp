package com.example.employee;

import java.util.List;
import java.util.Scanner;


public class EmployeeApp {
    private static final Scanner sc = new Scanner(System.in);
    private static final EmployeeDAO dao = new EmployeeDAO();

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            printMenu();
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1" -> addEmployee();
                case "2" -> listEmployees();
                case "3" -> viewEmployee();
                case "4" -> updateEmployee();
                case "5" -> deleteEmployee();
                case "6" -> run = false;
                default -> System.out.println("Enter 1-6");
            }
        }
        System.out.println("Exiting. Goodbye!");
    }

    private static void printMenu() {
        System.out.println("\n--- Employee App ---");
        System.out.println("1. Add Employee");
        System.out.println("2. List All Employees");
        System.out.println("3. View Employee by ID");
        System.out.println("4. Update Employee");
        System.out.println("5. Delete Employee");
        System.out.println("6. Exit");
        System.out.print("Choose: ");
    }

    private static void addEmployee() {
        System.out.print("NAME: "); String NAME = sc.nextLine().trim();
        System.out.print("EMAIL: "); String EMAIL = sc.nextLine().trim();
        System.out.print("DEPARTMENT: "); String DEPARTMENT = sc.nextLine().trim();
        System.out.print("SALARY: "); double SALARY = Double.parseDouble(sc.nextLine().trim());

        Employee e = new Employee(NAME, EMAIL, DEPARTMENT, SALARY);
        boolean ok = dao.addEmployee(e);
        System.out.println(ok ? "Added: " + e : "Failed to add employee.");
    }

    private static void listEmployees() {
        List<Employee> list = dao.getAllEmployees();
        if (list.isEmpty()) System.out.println("No employees found.");
        else list.forEach(System.out::println);
    }

    private static void viewEmployee() {
        System.out.print("Enter ID: ");
        int ID = Integer.parseInt(sc.nextLine().trim());
        Employee e = dao.getEmployeeById(ID);
        System.out.println(e == null ? "Not found" : e);
    }

    private static void updateEmployee() {
        System.out.print("Enter ID to update: ");
        int ID = Integer.parseInt(sc.nextLine().trim());
        Employee existing = dao.getEmployeeById(ID);
        if (existing == null) { System.out.println("Employee not found."); return; }

        System.out.println("Leave blank to keep current value.");
        System.out.print("NAME (" + existing.getNAME() + "): ");
        String NAME = sc.nextLine().trim(); if (!NAME.isEmpty()) existing.setName(NAME);

        System.out.print("EMAIL (" + existing.getEMAIL() + "): ");
        String EMAIL = sc.nextLine().trim(); if (!EMAIL.isEmpty()) existing.setEmail(EMAIL);

        System.out.print("DEPARTMENT (" + existing.getDEPARTMENT() + "): ");
        String DEPARTMENT = sc.nextLine().trim(); if (!DEPARTMENT.isEmpty()) existing.setDepartment(DEPARTMENT);

        System.out.print("SALARY (" + existing.getSALARY() + "): ");
        String SALARYStr = sc.nextLine().trim();
        if (!SALARYStr.isEmpty()) existing.setSalary(Double.parseDouble(SALARYStr));

        boolean ok = dao.updateEmployee(existing);
        System.out.println(ok ? "Updated." : "Update failed.");
    }

    private static void deleteEmployee() {
        System.out.print("Enter ID to delete: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        boolean ok = dao.deleteEmployee(id);
        System.out.println(ok ? "Deleted." : "Delete failed (maybe not found).");
    }
}
