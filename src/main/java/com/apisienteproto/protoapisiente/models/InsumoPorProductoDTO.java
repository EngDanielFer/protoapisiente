package com.apisienteproto.protoapisiente.models;

import java.math.BigDecimal;

public class InsumoPorProductoDTO {

    private int idInsumo;
    private String nombreInsumo;
    private BigDecimal cantidadInsumo;
    private BigDecimal precioInsumo;
    
    public InsumoPorProductoDTO(int idInsumo, String nombreInsumo, BigDecimal cantidadInsumo, BigDecimal precioInsumo) {
        this.idInsumo = idInsumo;
        this.nombreInsumo = nombreInsumo;
        this.cantidadInsumo = cantidadInsumo;
        this.precioInsumo = precioInsumo;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
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
