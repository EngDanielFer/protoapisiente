package com.apisienteproto.protoapisiente.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "facturas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fecha;

    @Column(name = "nombre_cliente", nullable = false, length = 50)
    private String nombreCliente;

    @Column(name = "apellido_cliente", nullable = false, length = 50)
    private String apellidoCliente;

    @Column(name = "email_cliente", nullable = false, length = 100)
    private String emailCliente;

    @Column(name = "direccion_cliente", nullable = false, length = 100)
    private String direccionCliente;

    @Column(name = "complemento_direccion", length = 100)
    private String complementoDireccion;

    @Column(name = "telefono_cliente", nullable = false, length = 15)
    private String telefonoCliente;

    @Column(name = "pais_cliente", nullable = false, length = 50)
    private String paisCliente;

    @Column(name = "region_cliente", nullable = false, length = 30)
    private String regionCliente;

    @Column(name = "ciudad_cliente", nullable = false, length = 30)
    private String ciudadCliente;

    @Column(name = "valor_pagado", precision = 10, scale = 2)
    private BigDecimal valorPagado;

    @Column(name = "precio_envio", precision = 10, scale = 2)
    private BigDecimal precioEnvio;

    @Column(name = "valor_total", precision = 10, scale = 2)
    private BigDecimal valorTotal;

    @Column(name = "metodo_pago", nullable = false, length = 30)
    private String metodoPago;

    @PrePersist
    protected void onCreate() {
        if (fecha == null) {
            fecha = LocalDateTime.now();
        }
    }
}
