
package com.conversor.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiService {

    public String obtenerDatos(String urlString) {

        try {

            URL url = new URL(urlString);

            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();

            conexion.setRequestMethod("GET");

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(conexion.getInputStream()));

            StringBuilder respuesta = new StringBuilder();

            String linea;

            while ((linea = reader.readLine()) != null) {

                respuesta.append(linea);

            }

            reader.close();

            return respuesta.toString();

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

}
