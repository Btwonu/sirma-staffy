package com.staffy.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class JsonReader {
    public ArrayList<JSONObject> getJsonList(Path filePath) {
        ArrayList<JSONObject> jsonList = new ArrayList<>();

        try {
            String content = Files.readString(filePath);
            JSONArray usersJArray = new JSONArray(content);

            for (int i = 0; i < usersJArray.length(); i++) {
                JSONObject JObject = usersJArray.getJSONObject(i);

                jsonList.add(JObject);
            }
        } catch (IOException | JSONException e) {
            System.out.println("IO or JSON bad");
        }

        return jsonList;
    }
}
