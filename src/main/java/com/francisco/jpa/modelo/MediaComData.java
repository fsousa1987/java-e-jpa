package com.francisco.jpa.modelo;

public class MediaComData {

    private final Double valor;
    private final Integer dia;
    private final Integer mes;

    public MediaComData(Double valor, Integer dia, Integer mes) {
        this.valor = valor;
        this.dia = dia;
        this.mes = mes;
    }

    public Double getValor() {
        return valor;
    }

    public Integer getDia() {
        return dia;
    }

    public Integer getMes() {
        return mes;
    }
}
