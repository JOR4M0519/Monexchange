package org.exchange.controller;

import com.google.gson.*;
import org.exchange.exception.AppException;
import org.exchange.model.MoneyDTO;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class RateExchangeMoney {
    // Setting URL
    private String url_str = "https://v6.exchangerate-api.com/v6/[api]/latest/";
    private String codeISO_source;
    private String codeISO_convert;
    private String[] listMoneyOptions;

    public RateExchangeMoney(String codeISO_source, String codeISO_convert) {
        this.codeISO_source = codeISO_source;
        this.codeISO_convert = codeISO_convert;
        url_str += this.codeISO_source;
        listMoneyOptions = new String[]{"USD", "EUR", "RUB", "GBP", "RMB", this.codeISO_convert};
    }


    public List<Map.Entry<String, Double>> getExchange() {


        List<Map.Entry<String, Double>> moneyRateList = new ArrayList<>();

        try {
            //Consulta API EXCHANGE
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url_str))
                    .build();

            //Recepción de consulta
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            //Estructura en json
            String json = response.body();


            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

            // Conversion JsonToGson
            MoneyDTO moneyDTO = gson.fromJson(json, MoneyDTO.class);

            Map<String, Double> conversionRates = moneyDTO.conversion_rates();





            for (String moneyType : listMoneyOptions) {
                if (conversionRates.containsKey(moneyType)) {
                    moneyRateList.add(Map.entry(moneyType, conversionRates.get(moneyType)));
                }
            }



        } catch (IOException e) {
            throw new AppException("error de conexión:\n" + e.getMessage(), 500);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

            throw new AppException("Solicitud Interrumpida:\n" + e.getMessage(), 500);
            // Restablecer interrupción

        } catch (Exception e) {
            throw new AppException("Ocurrio un error interno:\n" + e.getMessage(), 500);
        }

        return moneyRateList;
    }

    public String getCodeISO_source() {
        return codeISO_source;
    }

    public void setCodeISO_source(String codeISO_source) {
        this.codeISO_source = codeISO_source;
        String result = url_str.substring(0, url_str.length() - 3) + codeISO_source;
    }

    public String getCodeISO_convert() {
        return codeISO_convert;
    }

    public void setCodeISO_convert(String codeISO_convert) {
        listMoneyOptions[5] = codeISO_convert;
        this.codeISO_convert = codeISO_convert;
    }
}
