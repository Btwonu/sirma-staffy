package com.staffy.staff.employee;

import java.time.LocalDate;

public class HREmployee extends Employee {
    public HREmployee(int id, String name, Department department, String role, double salary, LocalDate startDate) {
        super(id, name, department, role, salary, startDate);
    }
}
