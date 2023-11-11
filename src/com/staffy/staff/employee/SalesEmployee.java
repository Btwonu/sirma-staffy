package com.staffy.staff.employee;

import java.time.LocalDate;

public class SalesEmployee extends Employee {
    public SalesEmployee(int id, String name, Department department, String role, double salary, LocalDate startDate) {
        super(id, name, department, role, salary, startDate);
    }
}
