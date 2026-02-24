package model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExchangeRate {

    private final String apiKey;
    private String base;
    private final String endPoint;          // url builder
    private final String baseURL;
    // private String currencyCode = "EUR"; // same as base (base = EUR [currencyCode])
    private final Map<String, BigDecimal> conversion_rates; // retrieved conversion rates with base conversion value


    public ExchangeRate() {
        this.apiKey = "MY_API_KEY";
        this.base = "";
        this.endPoint = "/latest/";
        this.baseURL = "https://v6.exchangerate-api.com/v6/";

        this.conversion_rates = new HashMap<>();
    }


    public void fetchData(String provided_base) throws Exception {
        conversion_rates.clear();
        this.base = provided_base.trim().toUpperCase();
        String full_url = baseURL + apiKey + endPoint + base;
        URL set_url = new URL(full_url);

        HttpURLConnection connection = (HttpURLConnection) set_url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        System.out.println("Response code: " + responseCode);

        if (responseCode != 200) {
            throw new Exception("Data didn't go through. Connection not successful. ");
        }

        String line;
        StringBuilder stringBuilder = new StringBuilder();
        JsonObject root;

        try (InputStream inputStream = connection.getInputStream();
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        )
        {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            String jsonResponse = stringBuilder.toString();
            root = JsonParser.parseString(jsonResponse).getAsJsonObject();

            if (!root.has("conversion_rates")) {
                throw new Exception("JSON output doesn't contain conversion rates. ");
            }

            JsonObject conversion_rates_json = root.getAsJsonObject("conversion_rates");

            for (Map.Entry<String, JsonElement> element : conversion_rates_json.entrySet()) {
                String element_key = element.getKey();
                BigDecimal element_value = element.getValue().getAsBigDecimal();
                conversion_rates.put(element_key, element_value);
            }

            System.out.println("Base currency chosen: " + this.base + " " + conversion_rates.get(this.base));

            // for (Map.Entry<String, BigDecimal> i : conversion_rates.entrySet()) {System.out.println(i);} // note that hashmaps do not guarantee sequential order, so base case (currency) will be unsorted
        } finally {
            connection.disconnect();
            System.out.println("Connection disconnected. ");
        }
    }

    public BigDecimal convert(String fromCurrencyCode, String targetCurrencyCode, BigDecimal multiplier) throws Exception {

        if (multiplier == null) {
            throw new IllegalArgumentException("Invalid amount");
        }
        String validate_from = fromCurrencyCode.trim().toUpperCase();
        BigDecimal from_amount = conversion_rates.get(validate_from);
        if (from_amount == null) {
            throw new IllegalArgumentException("Invalid from currency.");
        }

        String validate_to = targetCurrencyCode.trim().toUpperCase();
        BigDecimal to_amount = conversion_rates.get(validate_to);
        if (to_amount == null) {
            throw new IllegalArgumentException("Invalid target currency.");
        }

        BigDecimal conversion = multiplier.divide(from_amount, 8, RoundingMode.HALF_UP).multiply(to_amount); // conversion formula = amount / from_currency * to_currency
        return conversion.setScale(2, RoundingMode.HALF_UP);
    }

    public ArrayList<String> getAllCurrencyCodes() {
        ArrayList<String> copy = new ArrayList<>(conversion_rates.keySet());
        System.out.println("All currency codes copied from Exchange Rate: " + copy);
        System.out.println("All currency codes size: " + copy.size());
        return copy;
    }
}