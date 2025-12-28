package com.apisienteproto.protoapisiente.models;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// import java.math.BigDecimal;
// import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacturaResponseDTO {

    private int id_factura;
    private String mensaje;
    private BigDecimal valor_total;
    private BigDecimal valor_pagado;
    private BigDecimal precio_envio;

//     private int id;
//     private LocalDateTime fecha;

//     private String nombreCliente;
//     private String apellidoCliente;
//     private String emailCliente;

//     private BigDecimal valorPagado;
//     private BigDecimal precioEnvio;
//     private BigDecimal valorTotal;
//     private String metodoPago;

//     public int getId() {
//         return id;
//     }

//     public void setId(int id) {
//         this.id = id;
//     }

//     public LocalDateTime getFecha() {
//         return fecha;
//     }

//     public void setFecha(LocalDateTime fecha) {
//         this.fecha = fecha;
//     }

//     public String getNombreCliente() {
//         return nombreCliente;
//     }

//     public void setNombreCliente(String nombreCliente) {
//         this.nombreCliente = nombreCliente;
//     }

//     public String getApellidoCliente() {
//         return apellidoCliente;
//     }

//     public void setApellidoCliente(String apellidoCliente) {
//         this.apellidoCliente = apellidoCliente;
//     }

//     public String getEmailCliente() {
//         return emailCliente;
//     }

//     public void setEmailCliente(String emailCliente) {
//         this.emailCliente = emailCliente;
//     }

//     public BigDecimal getValorPagado() {
//         return valorPagado;
//     }

//     public void setValorPagado(BigDecimal valorPagado) {
//         this.valorPagado = valorPagado;
//     }

//     public BigDecimal getPrecioEnvio() {
//         return precioEnvio;
//     }

//     public void setPrecioEnvio(BigDecimal precioEnvio) {
//         this.precioEnvio = precioEnvio;
//     }

//     public BigDecimal getValorTotal() {
//         return valorTotal;
//     }

//     public void setValorTotal(BigDecimal valorTotal) {
//         this.valorTotal = valorTotal;
//     }

//     public String getMetodoPago() {
//         return metodoPago;
//     }

//     public void setMetodoPago(String metodoPago) {
//         this.metodoPago = metodoPago;
//     }

}
