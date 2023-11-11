package com.staffy.staff.employee;

import java.time.LocalDate;

public class MarketingEmployee extends Employee {
    public MarketingEmployee(int id, String name, Department department, String role, double salary, LocalDate startDate) {
        super(id, name, department, role, salary, startDate);
    }
}
