package com.apisienteproto.protoapisiente.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="insumos")
public class InsumosModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre_insumo;

    @Column
    private BigDecimal cantidad_insumo_total;

    @Column
    private BigDecimal cantidad_insumo_restante;

    @Column
    private String proveedor_insumo;

    @Column
    private BigDecimal precio_insumo;

    @Column
    private BigDecimal precio_por_g_ml;

    @Column
    private String estado_insumo = "Disponible";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_insumo() {
        return nombre_insumo;
    }

    public void setNombre_insumo(String nombre_insumo) {
        this.nombre_insumo = nombre_insumo;
    }

    public BigDecimal getCantidad_insumo_total() {
        return cantidad_insumo_total;
    }

    public void setCantidad_insumo_total(BigDecimal cantidad_insumo_total) {
        this.cantidad_insumo_total = cantidad_insumo_total;
    }

    public BigDecimal getCantidad_insumo_restante() {
        return cantidad_insumo_restante;
    }

    public void setCantidad_insumo_restante(BigDecimal cantidad_insumo_restante) {
        this.cantidad_insumo_restante = cantidad_insumo_restante;
    }

    public String getProveedor_insumo() {
        return proveedor_insumo;
    }

    public void setProveedor_insumo(String proveedor_insumo) {
        this.proveedor_insumo = proveedor_insumo;
    }

    public BigDecimal getPrecio_insumo() {
        return precio_insumo;
    }

    public void setPrecio_insumo(BigDecimal precio_insumo) {
        this.precio_insumo = precio_insumo;
    }

    public BigDecimal getPrecio_por_g_ml() {
        return precio_por_g_ml;
    }

    public void setPrecio_por_g_ml(BigDecimal precio_por_g_ml) {
        this.precio_por_g_ml = precio_por_g_ml;
    }

    public String getEstado_insumo() {
        return estado_insumo;
    }

    public void setEstado_insumo(String estado_insumo) {
        this.estado_insumo = estado_insumo;
    }

    

}
