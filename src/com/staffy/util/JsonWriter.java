package com.staffy.util;

import com.staffy.staff.employee.Employee;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.exit;

public class JsonWriter {
    public void storeEmployeeMap(HashMap<Integer, Employee> employeesMap, Path filePath) {
        JSONArray JArray = new JSONArray();

        for (Map.Entry<Integer, Employee> entry : employeesMap.entrySet()) {
            JSONObject JObject = new JSONObject(entry.getValue());

            JArray.put(JObject);
        }

        try {
            Files.writeString(filePath, JArray.toString(4));
        } catch (IOException e) {
            System.out.println("Cannot write to json file");
            return;
        }

        System.out.println("Goodbye!");
        exit(0);
    }
}
