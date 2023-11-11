import com.staffy.Service;
import com.staffy.cli.StaffManager;
import com.staffy.staff.StaffService;
import com.staffy.staff.employee.Employee;
import com.staffy.util.JsonReader;
import com.staffy.util.JsonWriter;

import java.util.Scanner;

public class Main {
    static boolean isRunning = true;
    static Scanner scanner;
    public static void main(String[] args) {
        JsonReader jsonReader = new JsonReader();
        JsonWriter jsonWriter = new JsonWriter();
        Service<Employee> staffService = new StaffService(jsonReader, jsonWriter);
        StaffManager manager = new StaffManager(staffService);

        try {
            scanner = new Scanner(System.in);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        displayCommands();

        while (isRunning) {
            String command = scanner.nextLine();
            manager.execute(command);
        }
    }

    private static void displayCommands() {
        System.out.println("Add - add a new employee");
        System.out.println("List - list all employees");
        System.out.println("Search id {id} - search for an employee by id");
        System.out.println("Search name {name} - search for an employee by name");
        System.out.println("Search department {department} - list employees from a department");
        System.out.println("Exit - Save & exit the application");
    }
}
