package com.example.employee;

public class Employee {
    private int ID;
    private String NAME;
    private String EMAIL;
    private String DEPARTMENT;
    private double SALARY;

    public Employee() {}

    public Employee(String NAME, String EMAIL, String DEPARTMENT, double SALARY) {
        this.NAME = NAME;
        this.EMAIL = EMAIL;
        this.DEPARTMENT = DEPARTMENT;
        this.SALARY = SALARY;
    }

    public Employee(int ID, String NAME, String EMAIL, String DEPARTMENT, double SALARY) {
        this.ID = ID; 
        this.NAME = NAME; 
        this.EMAIL = EMAIL; 
        this.DEPARTMENT = DEPARTMENT; 
        this.SALARY = SALARY;
    }

    
    public int getId() { 
    	return ID; 
    	}
    public void setId(int ID) { 
    	this.ID = ID; 
    	}
    public String getNAME() { 
    	return NAME; 
    	}
    public void setName(String NAME) { 
    	this.NAME = NAME; 
    	}
    public String getEMAIL() { 
    	return EMAIL; 
    	}
    public void setEmail(String EMAIL) { 
    	this.EMAIL = EMAIL; 
    	}
    public String getDEPARTMENT() { 
    	return DEPARTMENT; 
    	}
    public void setDepartment(String DEPARTMENT) { 
    	this.DEPARTMENT = DEPARTMENT; 
    	}
    public double getSALARY() { 
    	return SALARY; 
    	}
    public void setSalary(double SALARY) { 
    	this.SALARY = SALARY; 
    	}

    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', email='%s', dept='%s', salary=%.2f}",
                ID, NAME, EMAIL, DEPARTMENT, SALARY);
    }
}
