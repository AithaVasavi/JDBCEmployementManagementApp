package com.example.employee;

import java.sql.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class EmployeeDAO {

    
    public boolean addEmployee(Employee emp) {
        String sql = "INSERT INTO employees(NAME, EMAIL, DEPARTMENT, SALARY) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, emp.getNAME());
            ps.setString(2, emp.getEMAIL());
            ps.setString(3, emp.getDEPARTMENT());
            ps.setDouble(4, emp.getSALARY());

            int rows = ps.executeUpdate();
            if (rows == 0) return false;

            // get generated id
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) emp.setId(rs.getInt(1));
            }
            return true;
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            System.err.println("Error adding employee: " + ex.getMessage());
            return false;
        }
    }

   
    public Employee getEmployeeById(int id) {
        String sql = "SELECT id, NAME, EMAIL, DEPARTMENT, SALARY FROM employees WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Employee(
                            rs.getInt("ID"),
                            rs.getString("NAME"),
                            rs.getString("EMAIL"),
                            rs.getString("DEPARTMENT"),
                            rs.getDouble("SALARY")
                    );
                }
            }
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            System.err.println("Error fetching employee: " + ex.getMessage());
        }
        return null;
    }

    
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT id, NAME, EMAIL, DEPARTMENT, SALARY FROM employees ORDER BY id";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt("ID"),
                        rs.getString("NAME"),
                        rs.getString("EMAIL"),
                        rs.getString("DEPARTMENT"),
                        rs.getDouble("SALARY")
                ));
            }
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            System.err.println("Error listing employees: " + ex.getMessage());
        }
        return list;
    }

    
    public boolean updateEmployee(Employee emp) {
        String sql = "UPDATE employees SET NAME = ?, EMAIL = ?, DEPARTMENT = ?, SALARY = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, emp.getNAME());
            ps.setString(2, emp.getEMAIL());
            ps.setString(3, emp.getDEPARTMENT());
            ps.setDouble(4, emp.getSALARY());
            ps.setInt(5, emp.getId());

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            System.err.println("Error updating employee: " + ex.getMessage());
            return false;
        }
    }

    
    public boolean deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            System.err.println("Error deleting employee: " + ex.getMessage());
            return false;
        }
    }
}

