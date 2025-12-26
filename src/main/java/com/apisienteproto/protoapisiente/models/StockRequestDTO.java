package com.apisienteproto.protoapisiente.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class StockRequestDTO {

    @NotNull(message="El ID del producto es obligatorio")
    @Min(value=1, message="El ID del producto debe ser mayor a 0")
    private int id_producto;

    @NotNull(message="La cantidad es requerida")
    @Min(value=1, message="La cantidad debe ser mayor a 0")
    private int cantidad_producto;

    public StockRequestDTO() {
    }

    public StockRequestDTO(int cantidad_producto, int id_producto) {
        this.cantidad_producto = cantidad_producto;
        this.id_producto = id_producto;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(int cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

}
