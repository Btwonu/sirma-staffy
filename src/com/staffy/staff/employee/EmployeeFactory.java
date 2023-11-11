package com.staffy.staff.employee;

import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class EmployeeFactory {
    public static Employee create(JSONObject employeeJObject) {
        int id = employeeJObject.getInt("Id");
        String name = employeeJObject.getString("Name");
        Department department = Department.valueOf(employeeJObject.getString("Department").toUpperCase());
        String role = employeeJObject.getString("Role");
        double salary = employeeJObject.getDouble("Salary");

        String dateFormat = "yyyy-MM-dd";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        LocalDate startDate = null;
        LocalDate endDate = null;

        try {
            startDate = LocalDate.parse(employeeJObject.getString("StartDate"), formatter);
            if (employeeJObject.has("EndDate")) {
                endDate = LocalDate.parse(employeeJObject.getString("EndDate"), formatter);
            }
        } catch (DateTimeParseException | JSONException e) {
            System.out.println("Invalid date format.");
            e.printStackTrace();
        }

        return switch (department) {
            case HR -> new HREmployee(id, name, department, role, salary, startDate);
            case FINANCE -> new FinanceEmployee(id, name, department, role, salary, startDate);
            case IT -> new ITEmployee(id, name, department, role, salary, startDate);
            case MARKETING -> new MarketingEmployee(id, name, department, role, salary, startDate);
            case SALES -> new SalesEmployee(id, name, department, role, salary, startDate);
        };
    }
}
