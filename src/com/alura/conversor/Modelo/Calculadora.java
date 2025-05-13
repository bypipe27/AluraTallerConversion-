package com.alura.conversor.Modelo;

public class Calculadora {

    public static double convertir(double cantidad, double tasaCambio, boolean esInversa) {
        if (esInversa) {
            return cantidad / tasaCambio; // Conversión inversa (ejemplo: ARS -> USD)
        } else {
            return cantidad * tasaCambio; // Conversión directa (ejemplo: USD -> ARS)
        }
    }
}
