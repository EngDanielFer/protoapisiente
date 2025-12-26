package com.apisienteproto.protoapisiente.models;

public class InsumoProductoDTO {
    private int id_insumo;
    private double cantidad;

    public InsumoProductoDTO() {
    }

    public InsumoProductoDTO(double cantidad, int id_insumo) {
        this.cantidad = cantidad;
        this.id_insumo = id_insumo;
    }

    public int getId_insumo() {
        return id_insumo;
    }

    public void setId_insumo(int id_insumo) {
        this.id_insumo = id_insumo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }


}
