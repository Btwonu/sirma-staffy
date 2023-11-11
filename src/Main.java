import com.staffy.Service;
import com.staffy.staff.StaffService;
import com.staffy.staff.employee.Employee;
import com.staffy.util.JsonReader;

public class Main {
    boolean isRunning = true;
    public static void main(String[] args) {
        JsonReader jsonReader = new JsonReader();
        Service<Employee> staffService = new StaffService(jsonReader);

        staffService.listAll();

        displayCommands();
    }

    private static void displayCommands() {
        System.out.println("Commands...");
    }
}