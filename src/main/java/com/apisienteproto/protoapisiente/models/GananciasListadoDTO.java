package com.apisienteproto.protoapisiente.models;

public class GananciasListadoDTO {

    private int id_ganancia;
    private int id_producto_stock;
    private double precio_insumos_total;
    private double ganancia_total_por_mayor;
    private double ganancia_total_detal;
    private double precio_total_por_mayor;
    private double precio_total_detal;
    private int id_producto;
    private String nombre_producto;
    
    public GananciasListadoDTO(GananciasModel ganancias) {
        this.id_ganancia = ganancias.getId_ganancia();
        this.id_producto_stock = ganancias.getId_producto_stock();
        this.precio_insumos_total = ganancias.getPrecio_insumos_total();
        this.ganancia_total_por_mayor = ganancias.getGanancia_total_por_mayor();
        this.ganancia_total_detal = ganancias.getGanancia_total_detal();
        this.precio_total_por_mayor = ganancias.getPrecio_total_por_mayor();
        this.precio_total_detal = ganancias.getPrecio_total_detal();
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

    public double getGanancia_total_por_mayor() {
        return ganancia_total_por_mayor;
    }

    public void setGanancia_total_por_mayor(double ganancia_total_por_mayor) {
        this.ganancia_total_por_mayor = ganancia_total_por_mayor;
    }

    public double getGanancia_total_detal() {
        return ganancia_total_detal;
    }

    public void setGanancia_total_detal(double ganancia_total_detal) {
        this.ganancia_total_detal = ganancia_total_detal;
    }

    public double getPrecio_total_por_mayor() {
        return precio_total_por_mayor;
    }

    public void setPrecio_total_por_mayor(double precio_total_por_mayor) {
        this.precio_total_por_mayor = precio_total_por_mayor;
    }

    public double getPrecio_total_detal() {
        return precio_total_detal;
    }

    public void setPrecio_total_detal(double precio_total_detal) {
        this.precio_total_detal = precio_total_detal;
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
