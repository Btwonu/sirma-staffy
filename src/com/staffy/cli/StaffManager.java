package com.staffy.cli;

import com.staffy.Service;
import com.staffy.staff.employee.Employee;
import com.staffy.staff.employee.EmployeeFactory;
import com.staffy.util.Input;

import java.util.Arrays;
import java.util.Scanner;

public class StaffManager {
    Service<Employee> staffService;

    public StaffManager(Service<Employee> staffService) {
        this.staffService = staffService;
    }

    public void execute(String command) {
        Input input = new Input(command);

        System.out.println(input.getCommand());

        if (input.getCommand().equalsIgnoreCase("Add")) {
            System.out.println("Please provide employee data in the following form: {id}, {name}, {department}, {role}, {salary}");

            Scanner scanner;
            try {
                scanner = new Scanner(System.in);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            String line = scanner.nextLine();
            String[] data = line.split(", ");

            this.staffService.add(data);
        }

        if (input.getCommand().equalsIgnoreCase("List")) {
            this.staffService.listAll();
        }
    }
}
