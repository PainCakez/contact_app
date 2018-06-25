package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Company implements Serializable, Comparable<Company> {

    public String companyName;
    public Employee employee;

    public Company() {
        companyName = null;
        employee = new Employee();
    }

    ArrayList<Company> companyList = new ArrayList<>();

    public String setCompanyName(String name) {
        return this.companyName = name;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void deleteCompany(Company toDelete, boolean deleteAllEmployees) {
        companyList.remove(toDelete);
    }

    public void sortCompany() {
        Collections.sort(companyList);
    }

    public Employee assignEmployee(Employee employee) {
        return this.employee = employee;
    }

    //public String showEmployee() {
       // return this.employee.employeeList.get;
    //}

    @Override
    public int compareTo(Company o) {
        int result = this.companyName.compareToIgnoreCase(o.companyName);
        return result;
    }
}
