package com.conversor.service;

import com.conversor.model.ExchangeResponse;
import com.google.gson.Gson;

public class ConversionService {

    private final String API_KEY = "TU_API_KEY";

    public void convertir(String base, String destino, double cantidad) {

        try {

            String url = "https://v6.exchangerate-api.com/v6/"
                    + API_KEY + "/pair/" + base + "/" + destino;

            ApiService api = new ApiService();

            String json = api.obtenerDatos(url);

            Gson gson = new Gson();

            ExchangeResponse datos = gson.fromJson(json, ExchangeResponse.class);

            double resultado = cantidad * datos.getConversion_rate();

            System.out.println(
                    "El valor de " + cantidad + " " + base +
                            " corresponde a " + resultado + " " + destino
            );

        } catch (Exception e) {

            System.out.println("Error en la conversión");

        }

    }

}
