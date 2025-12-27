package com.apisienteproto.protoapisiente.models;

import java.math.BigDecimal;
import java.util.List;

public class FacturaRequestDTO {

    private String nombreCliente;
    private String apellidoCliente;
    private String emailCliente;
    private String direccionCliente;
    private String complementoDireccion;
    private String telefonoCliente;
    private String paisCliente;
    private String regionCliente;
    private String ciudadCliente;

    private BigDecimal precioEnvio;
    private String metodoPago;

    private List<FacturaProductoDTO> productos;

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

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getComplementoDireccion() {
        return complementoDireccion;
    }

    public void setComplementoDireccion(String complementoDireccion) {
        this.complementoDireccion = complementoDireccion;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getPaisCliente() {
        return paisCliente;
    }

    public void setPaisCliente(String paisCliente) {
        this.paisCliente = paisCliente;
    }

    public String getRegionCliente() {
        return regionCliente;
    }

    public void setRegionCliente(String regionCliente) {
        this.regionCliente = regionCliente;
    }

    public String getCiudadCliente() {
        return ciudadCliente;
    }

    public void setCiudadCliente(String ciudadCliente) {
        this.ciudadCliente = ciudadCliente;
    }

    public BigDecimal getPrecioEnvio() {
        return precioEnvio;
    }

    public void setPrecioEnvio(BigDecimal precioEnvio) {
        this.precioEnvio = precioEnvio;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public List<FacturaProductoDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<FacturaProductoDTO> productos) {
        this.productos = productos;
    }

    
}
