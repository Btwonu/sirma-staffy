package com.staffy.staff;

import com.staffy.Service;
import com.staffy.staff.employee.Department;
import com.staffy.staff.employee.Employee;
import com.staffy.staff.employee.EmployeeFactory;
import com.staffy.util.Config;
import com.staffy.util.JsonReader;
import org.json.JSONObject;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StaffService implements Service<Employee> {
    JsonReader reader;
    private HashMap<Integer, Employee> employeesMap = new HashMap<>();

    public StaffService(JsonReader reader) {
        this.reader = reader;
        this.load();
    }

    private void load() {
        Config config = Config.getInstance();
        String pathString = config.getEnv("EMPLOYEES_PATH");

        this.employeesMap = reader.getEmployeesMap(Path.of(pathString).resolve("all.json"));
    }

    @Override
    public void listAll() {
        for (Map.Entry<Integer, Employee> entry : this.employeesMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    @Override
    public Employee add(String[] data) {
        int id = Integer.parseInt(data[0]);
        String name = String.valueOf(data[1]);
        String department = String.valueOf(data[2]).toUpperCase();
        String role = String.valueOf(data[3]);
        double salary = Double.parseDouble(data[4]);
        LocalDate startDate = LocalDate.now();

        Employee newEmployee = EmployeeFactory.create(id, name, department, role, salary, startDate);
        if (employeesMap.containsKey(id)) {
            System.out.println("There is already an employee with this id");
            return null;
        }

        employeesMap.put(newEmployee.getId(), newEmployee);

        System.out.println("Added new employee:");
        System.out.println(newEmployee);
        return newEmployee;
    }

    @Override
    public Employee editById(int id) {
        return null;
    }

    @Override
    public Employee searchById(int id) {
        return null;
    }

    public Employee searchByName(String name) {
        return null;
    }

    public Employee searchByDepartment(String department) {
        return null;
    }

    public void fire(int id) {}
}
