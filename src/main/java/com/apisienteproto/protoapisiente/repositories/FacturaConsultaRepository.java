package com.apisienteproto.protoapisiente.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class FacturaConsultaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Object[]> listarFacturas() {

        String sql = """
            SELECT 
                id,
                fecha,
                nombre_cliente,
                apellido_cliente,
                email_cliente,
                valor_pagado,
                precio_envio,
                valor_total,
                metodo_pago
            FROM facturas
            ORDER BY fecha DESC
        """;

        return entityManager.createNativeQuery(sql).getResultList();
    }

    public Object[] obtenerFacturaPorId(int idFactura) {

        String sql = """
            SELECT 
                id,
                fecha,
                nombre_cliente,
                apellido_cliente,
                email_cliente,
                valor_pagado,
                precio_envio,
                valor_total,
                metodo_pago
            FROM facturas
            WHERE id = :idFactura
        """;

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("idFactura", idFactura);

        return (Object[]) query.getSingleResult();
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

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("idFactura", idFactura);

        return query.getResultList();
    }

}
