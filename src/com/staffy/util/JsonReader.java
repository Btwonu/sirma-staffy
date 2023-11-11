package com.staffy.util;

import com.staffy.staff.employee.Employee;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class JsonReader {
    public ArrayList<JSONObject> getJsonList(Path filePath) {
        ArrayList<JSONObject> jsonList = new ArrayList<>();

        try {
            String content = Files.readString(filePath);
            JSONArray contentJArray = new JSONArray(content);

            for (int i = 0; i < contentJArray.length(); i++) {
                JSONObject JObject = contentJArray.getJSONObject(i);

                jsonList.add(JObject);
            }
        } catch (IOException | JSONException e) {
            System.out.println("IO or JSON bad");
            e.printStackTrace();
        }

        return jsonList;
    }
}
