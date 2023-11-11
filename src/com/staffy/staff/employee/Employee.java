package com.staffy.staff.employee;

import java.time.LocalDate;

public abstract class Employee {
    private int id;
    private String name;
    private Department department;
    private String role;
    private double salary;
    private LocalDate startDate;
    private LocalDate endDate;

    public Employee(int id, String name, Department department, String role, double salary, LocalDate startDate) {
        this.setId(id);
        this.setName(name);
        this.setDepartment(department);
        this.setRole(role);
        this.setSalary(salary);
        this.setStartDate(startDate);
    }

    public Employee(int id, String name, Department department, String role, double salary, LocalDate startDate, LocalDate endDate) {
        this(id, name, department, role, salary, startDate);
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public Department getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
    public double getSalary() {
        return salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name.length() < 3) {
            throw new IllegalArgumentException("Employee name must be longer");
        }

        this.name = name;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("===============================================================%n"));
        sb.append(String.format("Name: %s%n", this.getName()));
        sb.append(String.format("Department: %s%n", this.getDepartment()));
        sb.append(String.format("Role: %s%n", this.getRole()));
        sb.append(String.format("Start date: %s%n", this.getStartDate()));
        sb.append(String.format("Salary: %.2f%n", this.getSalary()));

        return sb.toString();
    }
}
