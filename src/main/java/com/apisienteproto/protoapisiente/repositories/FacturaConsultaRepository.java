package com.apisienteproto.protoapisiente.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class FacturaConsultaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Object[]> listarFacturas() {

        String sql = """
            SELECT 
                f.id,
                f.fecha,
                f.nombre_cliente,
                f.apellido_cliente,
                f.email_cliente,
                f.valor_pagado,
                f.precio_envio,
                f.valor_total,
                f.metodo_pago
            FROM facturas f
            ORDER BY f.fecha DESC
        """;

        return entityManager.createNativeQuery(sql).getResultList();
    }

    public Object[] obtenerFacturaPorId(int id) {

        String sql = """
            SELECT 
                f.id,
                f.fecha,
                f.nombre_cliente,
                f.apellido_cliente,
                f.email_cliente,
                f.direccion_cliente,
                f.complemento_direccion,
                f.telefono_cliente,
                f.pais_cliente,
                f.region_cliente,
                f.ciudad_cliente,
                f.valor_pagado,
                f.precio_envio,
                f.valor_total,
                f.metodo_pago
            FROM facturas f
            WHERE f.id = :id
        """;

        return (Object[]) entityManager
                .createNativeQuery(sql)
                .setParameter("id", id)
                .getSingleResult();
    }

    public List<Object[]> obtenerDetalleFactura(int idFactura) {

        String sql = """
            SELECT 
                fd.id_producto,
                p.nombre_producto,
                fd.cantidad_producto,
                fd.precio_unitario,
                fd.subtotal
            FROM factura_detalle fd
            INNER JOIN productos p ON p.id = fd.id_producto
            WHERE fd.id_factura = :idFactura
        """;

        return entityManager
                .createNativeQuery(sql)
                .setParameter("idFactura", idFactura)
                .getResultList();
    }

    public List<Object[]> listarFacturasBase() {
        String sql = """
            SELECT 
                f.id,
                f.fecha,
                f.nombre_cliente,
                f.apellido_cliente,
                f.email_cliente,
                f.direccion_cliente,
                f.complemento_direccion,
                f.telefono_cliente,
                f.pais_cliente,
                f.region_cliente,
                f.ciudad_cliente,
                f.valor_pagado,
                f.precio_envio,
                f.valor_total,
                f.metodo_pago
            FROM facturas f
            ORDER BY f.fecha DESC
        """;

        return entityManager.createNativeQuery(sql).getResultList();
    }

}
