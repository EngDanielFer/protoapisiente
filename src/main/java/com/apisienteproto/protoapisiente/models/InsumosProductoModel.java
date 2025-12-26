package com.apisienteproto.protoapisiente.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name="insumos_por_producto")
@IdClass(InsumoPorProductoId.class)
public class InsumosProductoModel {
    
    @Id
    @Column(name="id_producto")
    private int idProducto;

    @Id
    @Column(name="id_insumo")
    private int idInsumo;

    @Column(name="cantidad_insumo")
    private BigDecimal cantidadInsumo;

    @Column(name = "precio_insumo")
    private BigDecimal precioInsumo;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public BigDecimal getCantidadInsumo() {
        return cantidadInsumo;
    }

    public void setCantidadInsumo(BigDecimal cantidadInsumo) {
        this.cantidadInsumo = cantidadInsumo;
    }

    public BigDecimal getPrecioInsumo() {
        return precioInsumo;
    }

    public void setPrecioInsumo(BigDecimal precioInsumo) {
        this.precioInsumo = precioInsumo;
    }

    
}
