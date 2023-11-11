package com.staffy.cli;

import com.staffy.Service;
import com.staffy.staff.employee.Employee;
import com.staffy.staff.employee.EmployeeFactory;
import com.staffy.util.Input;

import java.util.ArrayList;
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

        if (input.getCommand().equalsIgnoreCase("search")) {
            System.out.println("Search:");
            String[] args = input.getArguments();
            Employee foundEmployee = null;
            ArrayList<Employee> results = null;

            if (args[0].equalsIgnoreCase("id")) {
                try {
                    foundEmployee = staffService.searchById(Integer.parseInt(args[1].trim()));
                } catch (NumberFormatException e) {
                    System.out.println("Unsupported id format");
                }
            } else if (args[0].equalsIgnoreCase("name")) {
                StringBuilder name = new StringBuilder();

                if (args.length > 2) {
                    for (int i = 1; i < args.length; i++) {
                        name.append(" ").append(args[i]);
                    }
                }

                foundEmployee = staffService.searchByName(name.toString().trim());
            } else if (args[0].equalsIgnoreCase("department")) {
                results = staffService.searchByDepartment(args[1].trim());
            } else {
                System.out.println("Unsupported search parameter provided");
            }

            if (foundEmployee != null) {
                System.out.println(foundEmployee);
            } else if (results != null && !results.isEmpty()) {
                for (Employee employee : results) {
                    System.out.println(employee);
                }
            } else {
                System.out.println("Employee not found");
            }
        }
    }
}
