package com.apisienteproto.protoapisiente.models;

public class GananciasListadoDTO {

    private int id_ganancia;
    private int id_producto_stock;
    private double precio_insumos_total;
    private double ganancia_total;
    private double precio_total;
    private int id_producto;
    private String nombre_producto;
    
    public GananciasListadoDTO(GananciasModel ganancias) {
        this.id_ganancia = ganancias.getId_ganancia();
        this.id_producto_stock = ganancias.getId_producto_stock();
        this.precio_insumos_total = ganancias.getPrecio_insumos_total();
        this.ganancia_total = ganancias.getGanancia_total();
        this.precio_total = ganancias.getPrecio_total();
        this.id_producto = ganancias.getId_producto();
        this.nombre_producto = ganancias.getProducto().getNombre_producto();
    }

    public int getId_ganancia() {
        return id_ganancia;
    }

    public void setId_ganancia(int id_ganancia) {
        this.id_ganancia = id_ganancia;
    }

    public int getId_producto_stock() {
        return id_producto_stock;
    }

    public void setId_producto_stock(int id_producto_stock) {
        this.id_producto_stock = id_producto_stock;
    }

    public double getPrecio_insumos_total() {
        return precio_insumos_total;
    }

    public void setPrecio_insumos_total(double precio_insumos_total) {
        this.precio_insumos_total = precio_insumos_total;
    }

    public double getGanancia_total() {
        return ganancia_total;
    }

    public void setGanancia_total(double ganancia_total) {
        this.ganancia_total = ganancia_total;
    }

    public double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(double precio_total) {
        this.precio_total = precio_total;
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
