package com.company;

public class Main {

    public static void main(String[] args) {

        Company company = new Company();
        Employee employee = new Employee();

        for (int i = 0; i < 5; i++) {
            Company toAdd = new Company();
            Employee toAdd2 = new Employee();
            company.companyList.add(i, toAdd);
            employee.employeeList.add(i, toAdd2);
        }

        for (int i = 0; i < 5; i++) {
            company.companyList.get(i).setCompanyName("Company " + (i + 1));
            employee.employeeList.get(i).setEmployeeyName(("Peter" + (i + 1)));
        }

        for (int i = 0; i < company.companyList.size(); i++) {
            System.out.print(company.companyList.get(i).getCompanyName() + ", ");
        }

        company.deleteCompany(company.companyList.get(1), false);

        System.out.println("\n -------------------------");

        for (int i = 0; i < company.companyList.size(); i++) {
            System.out.print(company.companyList.get(i).getCompanyName() + ", ");
        }

        company.companyList.remove(3);
        //company.companyList.remove(3);

        company.companyList.get(0).setCompanyName("Gamma");
        company.companyList.get(1).setCompanyName("Beta");
        company.companyList.get(2).setCompanyName("Alpha");

        System.out.println("\n -------------------------");

        for (int i = 0; i < company.companyList.size(); i++) {
            System.out.print(company.companyList.get(i).getCompanyName() + ", ");
        }

        company.sortCompany();

        System.out.println("\n -------------------------");

        for (int i = 0; i < company.companyList.size(); i++) {
            System.out.print(company.companyList.get(i).getCompanyName() + ", ");
        }

        for (int i = 0; i < employee.employeeList.size(); i++) {
            company.companyList.get(0).assignEmployee(employee.employeeList.get(i));
        }

        System.out.println("\n -------------------------");

        //System.out.print(company.companyList.get(0).employee.employeeList);
    }
}
