package com.staffy.util;

import com.staffy.staff.employee.Department;
import com.staffy.staff.employee.Employee;
import com.staffy.staff.employee.EmployeeFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;

public class JsonReader {
    public HashMap<Integer, Employee> getEmployeesMap(Path filePath) {
        HashMap<Integer, Employee> employeesMap = new HashMap<>();

        try {
            String content = Files.readString(filePath);
            JSONArray contentJArray = new JSONArray(content);

            for (int i = 0; i < contentJArray.length(); i++) {
                JSONObject employeeJObject = contentJArray.getJSONObject(i);

                int id = employeeJObject.getInt("Id");
                String name = employeeJObject.getString("Name");
                String departmentString = employeeJObject.getString("Department").toUpperCase();
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

                Employee newEmployee = EmployeeFactory.create(id, name, departmentString, role, salary, startDate);
                employeesMap.put(id, newEmployee);
            }
        } catch (IOException | JSONException e) {
            System.out.println("IO or JSON bad");
            e.printStackTrace();
        }

        return employeesMap;
    }
}
