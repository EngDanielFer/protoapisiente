package com.apisienteproto.protoapisiente.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

@Repository
public class FacturaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public int insertarFactura(
            String nombre,
            String apellido,
            String email,
            String direccion,
            String complemento,
            String telefono,
            String pais,
            String region,
            String ciudad,
            List<?> productos,
            BigDecimal envio,
            String metodoPago
    ) throws Exception {
        String productosJson = objectMapper.writeValueAsString(productos);

        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery("p_insertar_factura");

        query.registerStoredProcedureParameter("n_cliente", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("ap_cliente", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("mail_cliente", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("direcc_cliente", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("comp_direcc_cliente", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("telef_cliente", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("country_cliente", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("reg_cliente", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("city_cliente", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("lista_productos", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("envio_cliente", BigDecimal.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("pago_cliente", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("out_id_factura", Integer.class, ParameterMode.OUT);

        query.setParameter("n_cliente", nombre);
        query.setParameter("ap_cliente", apellido);
        query.setParameter("mail_cliente", email);
        query.setParameter("direcc_cliente", direccion);
        query.setParameter("comp_direcc_cliente", complemento);
        query.setParameter("telef_cliente", telefono);
        query.setParameter("country_cliente", pais);
        query.setParameter("reg_cliente", region);
        query.setParameter("city_cliente", ciudad);
        query.setParameter("lista_productos", productosJson);
        query.setParameter("envio_cliente", envio);
        query.setParameter("pago_cliente", metodoPago);

        query.execute();

        return (int) query.getOutputParameterValue("out_id_factura");
    }
}
