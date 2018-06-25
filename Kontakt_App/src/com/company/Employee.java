package com.company;

import java.util.ArrayList;

public class Employee{

    public String employeeName;

    public Employee() {
        employeeName = null;
    }

    ArrayList<Employee> employeeList = new ArrayList<>();

    public String setEmployeeyName(String name) {
        return this.employeeName = name;
    }

    public String getEmployeeName() {
        return this.employeeName;
    }
}
