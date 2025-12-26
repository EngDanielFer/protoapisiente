package com.apisienteproto.protoapisiente.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ganancias_productos")
public class GananciasModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_ganancia;

    @Column(name="id_producto", insertable=false, updatable=false)
    private int id_producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_producto")
    private ProductosModel producto;

    public int getId_ganancia() {
        return id_ganancia;
    }

    public void setId_ganancia(int id_ganancia) {
        this.id_ganancia = id_ganancia;
    }

    public ProductosModel getProducto() {
        return producto;
    }

    public void setProducto(ProductosModel producto) {
        this.producto = producto;
    }

    @Column
    private int id_producto_stock;

    @Column
    private int precio_insumos_total;

    @Column
    private int ganancia_total_por_mayor;

    @Column
    private int ganancia_total_detal;

    @Column
    private int precio_total_por_mayor;

    @Column
    private int precio_total_detal;

    public int getIdGanancia() {
        return id_ganancia;
    }

    public void setIdGanancia(int id_ganancia) {
        this.id_ganancia = id_ganancia;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_producto_stock() {
        return id_producto_stock;
    }

    public void setId_producto_stock(int id_producto_stock) {
        this.id_producto_stock = id_producto_stock;
    }

    public int getPrecio_insumos_total() {
        return precio_insumos_total;
    }

    public void setPrecio_insumos_total(int precio_insumos_total) {
        this.precio_insumos_total = precio_insumos_total;
    }

    public int getGanancia_total_por_mayor() {
        return ganancia_total_por_mayor;
    }

    public void setGanancia_total_por_mayor(int ganancia_total_por_mayor) {
        this.ganancia_total_por_mayor = ganancia_total_por_mayor;
    }

    public int getGanancia_total_detal() {
        return ganancia_total_detal;
    }

    public void setGanancia_total_detal(int ganancia_total_detal) {
        this.ganancia_total_detal = ganancia_total_detal;
    }

    public int getPrecio_total_por_mayor() {
        return precio_total_por_mayor;
    }

    public void setPrecio_total_por_mayor(int precio_total_por_mayor) {
        this.precio_total_por_mayor = precio_total_por_mayor;
    }

    public int getPrecio_total_detal() {
        return precio_total_detal;
    }

    public void setPrecio_total_detal(int precio_total_detal) {
        this.precio_total_detal = precio_total_detal;
    }

    
}
