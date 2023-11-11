package com.staffy.staff.employee;

import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class EmployeeFactory {
    public static Employee create(int id, String name, String departmentString, String role, double salary, LocalDate startDate) {
        Department department = Department.valueOf(departmentString);

        return switch (department) {
            case HR -> new HREmployee(id, name, department, role, salary, startDate);
            case FINANCE -> new FinanceEmployee(id, name, department, role, salary, startDate);
            case IT -> new ITEmployee(id, name, department, role, salary, startDate);
            case MARKETING -> new MarketingEmployee(id, name, department, role, salary, startDate);
            case SALES -> new SalesEmployee(id, name, department, role, salary, startDate);
        };
    }
}
