package com.staffy.staff;

import com.staffy.Service;
import com.staffy.staff.employee.Employee;
import com.staffy.staff.employee.EmployeeFactory;
import com.staffy.util.Config;
import com.staffy.util.JsonReader;
import org.json.JSONObject;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class StaffService implements Service<Employee> {
    JsonReader reader;
    private HashMap<Integer, Employee> employeesMap = new HashMap<>();

    public StaffService(JsonReader reader) {
        this.reader = reader;
    }

    private void load() {
        Config config = Config.getInstance();
        String pathString = config.getEnv("EMPLOYEES_PATH");

        ArrayList<JSONObject> jsonList = reader.getJsonList(Path.of(pathString).resolve("all.json"));

        for (JSONObject JObject : jsonList) {
            Employee newEmployee = EmployeeFactory.create(JObject);

            employeesMap.put(newEmployee.getId(), newEmployee);
        }
    }

    @Override
    public void listAll() {
        System.out.println("Listing all employees");
    }

    @Override
    public Employee add(int id) {
        System.out.printf("Adding an employee: %d", id);
        return null;
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
