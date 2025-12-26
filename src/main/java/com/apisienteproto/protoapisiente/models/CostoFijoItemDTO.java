package com.apisienteproto.protoapisiente.models;

public class CostoFijoItemDTO {

    private String nombre;
    private double costo;

    public CostoFijoItemDTO() {
    }

    public CostoFijoItemDTO(String nombre, double costo) {
        this.nombre = nombre;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    
    
}
