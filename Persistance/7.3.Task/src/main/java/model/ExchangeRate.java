package model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ExchangeRate {

    private final String apiKey = "api_key";
    private final String baseURL = "https://v6.exchangerate-api.com/v6/";
    private final String endPoint = "/latest/";
    private Map<String, BigDecimal> conversionRates = new HashMap<>();

    public void fetchData(String base) throws Exception {
        conversionRates.clear();
        String urlStr = baseURL + apiKey + endPoint + base.trim().toUpperCase();
        HttpURLConnection conn = (HttpURLConnection) new URL(urlStr).openConnection();
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new Exception("API request failed with code: " + responseCode);
        }

        StringBuilder sb = new StringBuilder();
        try (InputStream in = conn.getInputStream();
             InputStreamReader reader = new InputStreamReader(in);
             BufferedReader br = new BufferedReader(reader)) {

            String line;
            while ((line = br.readLine()) != null) sb.append(line);
        }

        JsonObject root = JsonParser.parseString(sb.toString()).getAsJsonObject();

        if (!root.has("conversion_rates")) {
            throw new Exception("API response does not contain conversion rates.");
        }

        JsonObject ratesJson = root.getAsJsonObject("conversion_rates");
        for (Map.Entry<String, JsonElement> e : ratesJson.entrySet()) {
            conversionRates.put(e.getKey(), e.getValue().getAsBigDecimal());
        }

        conn.disconnect();
    }

    public Map<String, BigDecimal> getConversionRates() {
        return conversionRates;
    }
}
