package com.apisienteproto.protoapisiente.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;

@Entity
@Table(name="productos_stock")
@NamedStoredProcedureQuery(
    name="p_insertar_stock_producto_ganancias",
    procedureName="p_insertar_stock_producto_ganancias",
    parameters={
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "prod_id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "prod_cantidad", type = Integer.class)
    }
)
public class StockModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_producto_stock;

    @Column(name = "id_producto", insertable = false, updatable = false)
    private int id_producto;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_producto")
    private ProductosModel producto;

    @Column
    private int cantidad_producto;

    @Column(name="fecha_insercion", nullable=false)
    private LocalDateTime fecha_insercion;

    public int getId_producto_stock() {
        return id_producto_stock;
    }

    public void setId_producto_stock(int id_producto_stock) {
        this.id_producto_stock = id_producto_stock;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public ProductosModel getProducto() {
        return producto;
    }

    public void setProducto(ProductosModel producto) {
        this.producto = producto;
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


}
