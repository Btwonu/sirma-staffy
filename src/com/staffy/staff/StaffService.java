package com.staffy.staff;

import com.staffy.Service;
import com.staffy.staff.employee.Employee;
import com.staffy.util.JsonReader;

public class StaffService implements Service<Employee> {
    JsonReader reader;

    public StaffService(JsonReader reader) {
        this.reader = reader;
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
