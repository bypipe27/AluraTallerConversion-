package com.alura.conversor.principal;
import com.alura.conversor.Modelo.Calculadora;
import com.alura.conversor.Modelo.Monedachange;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();

        String direccion = "https://v6.exchangerate-api.com/v6/2b9160d3a600c316356c40b5/latest/USD";

        while (true) {
            System.out.println(
                    """
                            --------------------------
                            BIENVENIDO CASA DE CAMBIO

                            Escoga una Opción
                            
                            1) Dolar -> Peso argentino
                            2) Peso Argentino -> Dolar
                            3) Dolar -> Real brasileño
                            4) Real brasileño -> Dolar
                            5) Dolar -> Peso Colombiano
                            6) Peso Colombiano -> Dolar
                            7) Salir
                            -------------------------------
                            """
            );
            System.out.println("Ingrese una opcion: ");
            var opcion = lectura.nextLine();
            if (opcion.equalsIgnoreCase("7") || opcion.equalsIgnoreCase("salir")) {
                System.out.println("Saliendo del programa...");
                break;
            }

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String respuesta = response.body();
                Monedachange moneda = gson.fromJson(respuesta, Monedachange.class);

                double tasaCambio = 0.0;
                boolean esInversa = false;
                String monedaDestino ;

                switch (opcion) {
                    case "1":
                        monedaDestino = "ARS";
                        tasaCambio = moneda.conversion_rates().get(monedaDestino);
                        break;
                    case "2": // Peso Argentino -> Dólar
                        monedaDestino = "USD";
                        tasaCambio = moneda.conversion_rates().get("ARS");
                        esInversa = true;
                        break;
                    case "3":
                        monedaDestino = "BRL";
                        tasaCambio = moneda.conversion_rates().get(monedaDestino);
                        break;
                    case "4":
                        monedaDestino = "USD";
                        tasaCambio = moneda.conversion_rates().get("BRL");
                        esInversa = true;
                        break;
                    case "5":
                        monedaDestino = "COP";
                        tasaCambio = moneda.conversion_rates().get(monedaDestino);
                        break;
                    case "6":
                        monedaDestino = "USD";
                        tasaCambio = moneda.conversion_rates().get("COP");
                        esInversa = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                        continue;
                }

                System.out.println("Tasa de cambio utilizada: " + tasaCambio);

                System.out.println("Ingrese la cantidad a convertir: ");
                double cantidad = lectura.nextDouble();
                lectura.nextLine();

                double resultado = Calculadora.convertir(cantidad, tasaCambio, esInversa);

                System.out.println("El resultado de la conversión es: " + resultado + monedaDestino);

            } catch (IOException | InterruptedException e) {
                System.out.println("Ocurrió un error al realizar la solicitud: " + e.getMessage());
            }
        }
    }
}