package com.cristhianvaldivia.aluraconversor;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class CurrencyConverter {

    private static final String API_KEY = "8jBsTJmf2LfpE4FEmanEluoHaFAUMOX4";
    private static final String API_URL = "https://api.apilayer.com/exchangerates_data/convert";

    public String convert(String from, String to, String amount) {
        OkHttpClient client = new OkHttpClient();
        String url = API_URL + "?to=" + to + "&from=" + from + "&amount=" + amount;
        Request request = new Request.Builder()
                .url(url)
                .addHeader("apikey", API_KEY)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                return null;
            }
            String responseBody = response.body().string();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(responseBody);
            return jsonNode.get("result").asText();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
