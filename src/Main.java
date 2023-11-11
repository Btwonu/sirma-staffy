import com.staffy.Service;
import com.staffy.cli.StaffManager;
import com.staffy.staff.StaffService;
import com.staffy.staff.employee.Employee;
import com.staffy.util.JsonReader;

import java.util.Scanner;

public class Main {
    static boolean isRunning = true;
    static Scanner scanner;
    public static void main(String[] args) {
        JsonReader jsonReader = new JsonReader();
        Service<Employee> staffService = new StaffService(jsonReader);
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
        System.out.println("Commands...");
    }
}