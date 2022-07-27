package com.edu.lab4.rest;

import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Rest {
    private static ObjectMapper mapper = new ObjectMapper();

    public static JsonNode get(String path) {
        return request("GET", path, null);
    }

    public static JsonNode post(String path, Object data) {
        return request("POST", path, data);
    }

    public static JsonNode put(String path, Object data) {
        return request("PUT", path, data);
    }

    public static void delete(String path) {
        request("DELETE", path, null);
    }

    private static JsonNode request(String method, String path, Object data) {
        try {
            // Request
            String uri = "https://poly-java-6-58f2f-default-rtdb.asia-southeast1.firebasedatabase.app" + path
                    + ".json";
            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestMethod(method);

            // DATA (POST and PUT only)
            if (method.equalsIgnoreCase("POST") || method.equalsIgnoreCase("PUT")) {
                conn.setDoOutput(true);
                mapper.writeValue(conn.getOutputStream(), data);
            }

            // RESPONSE
            int respCode = conn.getResponseCode();
            if (respCode == 200) {
                return mapper.readTree(conn.getInputStream());
            }
            conn.disconnect();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
