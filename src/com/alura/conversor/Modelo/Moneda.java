package com.alura.conversor.Modelo;

import java.util.Map;

public class Moneda {

    String moneda;
    Map<String, Double> valor;
    String base = "USD";

//    public Moneda(Monedachange moneda) {
//        this.moneda = moneda.base_code();
//        this.valor = moneda.conversion_rates();
//    }

    @Override
    public String toString() {
        return "Moneda{" +
                "moneda='" + moneda + '\'' +
                ", valor=" + valor +
                ", base='" + base + '\'' +
                '}';
    }
}
