package com.cristhianvaldivia.aluraconversor;

import okhttp3.*;

import java.io.IOException;

public class ApiClient {

    private static final String API_KEY = "8jBsTJmf2LfpE4FEmanEluoHaFAUMOX4";
    private static final String API_URL = "https://api.apilayer.com/exchangerates_data/convert";

    public String getConversion(String from, String to, String amount) {
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(API_URL).newBuilder();
        urlBuilder.addQueryParameter("to", to);
        urlBuilder.addQueryParameter("from", from);
        urlBuilder.addQueryParameter("amount", amount);

        Request request = new Request.Builder()
                .url(urlBuilder.build().toString())
                .addHeader("apikey", API_KEY)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful() && response.body() != null) {
                return response.body().string();
            }
        } catch (IOException e) {
        }
        return null;
    }
}
