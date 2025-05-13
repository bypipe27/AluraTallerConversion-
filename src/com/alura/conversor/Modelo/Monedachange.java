package com.alura.conversor.Modelo;

import java.util.Map;

public record Monedachange(
        String base_code,
        Map<String, Double> conversion_rates
) {
}
