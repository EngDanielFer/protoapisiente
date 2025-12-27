package com.apisienteproto.protoapisiente.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class FacturaResponseDTO {

    private int idFactura;
    private LocalDateTime fecha;

    private String nombreCliente;
    private String apellidoCliente;
    private String emailCliente;

    private BigDecimal valorPagado;
    private BigDecimal precioEnvio;
    private BigDecimal valorTotal;
    private String metodoPago;

    private List<FacturaDetalleDTO> detalle;

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public BigDecimal getValorPagado() {
        return valorPagado;
    }

    public void setValorPagado(BigDecimal valorPagado) {
        this.valorPagado = valorPagado;
    }

    public BigDecimal getPrecioEnvio() {
        return precioEnvio;
    }

    public void setPrecioEnvio(BigDecimal precioEnvio) {
        this.precioEnvio = precioEnvio;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public List<FacturaDetalleDTO> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<FacturaDetalleDTO> detalle) {
        this.detalle = detalle;
    }

}
