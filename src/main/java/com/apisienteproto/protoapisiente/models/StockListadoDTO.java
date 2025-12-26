package com.apisienteproto.protoapisiente.models;

import java.time.LocalDateTime;

public class StockListadoDTO {

    private int id_producto_stock;
    private int cantidad_producto;
    private LocalDateTime fecha_insercion;
    private int id_producto;
    private String nombre_producto;

    public StockListadoDTO(StockModel stock) {
        this.id_producto_stock = stock.getId_producto_stock();
        this.cantidad_producto = stock.getCantidad_producto();
        this.fecha_insercion = stock.getFecha_insercion();
        this.id_producto = stock.getId_producto();
        this.nombre_producto = stock.getProducto().getNombre_producto();
    }

    public int getId_producto_stock() {
        return id_producto_stock;
    }

    public void setId_producto_stock(int id_producto_stock) {
        this.id_producto_stock = id_producto_stock;
    }

    public int getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(int cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    public LocalDateTime getFecha_insercion() {
        return fecha_insercion;
    }

    public void setFecha_insercion(LocalDateTime fecha_insercion) {
        this.fecha_insercion = fecha_insercion;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    

}
