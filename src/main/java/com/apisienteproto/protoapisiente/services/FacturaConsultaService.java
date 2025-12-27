package com.apisienteproto.protoapisiente.services;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.apisienteproto.protoapisiente.models.FacturaDetalleDTO;
import com.apisienteproto.protoapisiente.models.FacturaResponseDTO;
import com.apisienteproto.protoapisiente.repositories.FacturaConsultaRepository;

@Service
public class FacturaConsultaService {

    private final FacturaConsultaRepository repository;

    public FacturaConsultaService(FacturaConsultaRepository repository) {
        this.repository = repository;
    }

    public List<FacturaResponseDTO> listarFacturas() {

        List<Object[]> rows = repository.listarFacturas();
        List<FacturaResponseDTO> facturas = new ArrayList<>();

        for (Object[] row : rows) {
            FacturaResponseDTO dto = new FacturaResponseDTO();

            dto.setIdFactura((int) row[0]);
            dto.setFecha(((Timestamp) row[1]).toLocalDateTime());
            dto.setNombreCliente((String) row[2]);
            dto.setApellidoCliente((String) row[3]);
            dto.setEmailCliente((String) row[4]);
            dto.setValorPagado((BigDecimal) row[5]);
            dto.setPrecioEnvio((BigDecimal) row[6]);
            dto.setValorTotal((BigDecimal) row[7]);
            dto.setMetodoPago((String) row[8]);

            facturas.add(dto);
        }

        return facturas;
    }

    public FacturaResponseDTO obtenerFacturaCompleta(int idFactura) {

        Object[] cabecera = repository.obtenerFacturaPorId(idFactura);
        List<Object[]> detalleRows = repository.obtenerDetalleFactura(idFactura);

        FacturaResponseDTO factura = new FacturaResponseDTO();

        factura.setIdFactura((int) cabecera[0]);
        factura.setFecha(((Timestamp) cabecera[1]).toLocalDateTime());
        factura.setNombreCliente((String) cabecera[2]);
        factura.setApellidoCliente((String) cabecera[3]);
        factura.setEmailCliente((String) cabecera[4]);
        factura.setValorPagado((BigDecimal) cabecera[5]);
        factura.setPrecioEnvio((BigDecimal) cabecera[6]);
        factura.setValorTotal((BigDecimal) cabecera[7]);
        factura.setMetodoPago((String) cabecera[8]);

        List<FacturaDetalleDTO> detalle = new ArrayList<>();

        for (Object[] row : detalleRows) {
            FacturaDetalleDTO d = new FacturaDetalleDTO();
            d.setIdProducto((int) row[0]);
            d.setNombreProducto((String) row[1]);
            d.setCantidadProducto((int) row[2]);
            d.setPrecioUnitario((BigDecimal) row[3]);
            d.setSubtotal((BigDecimal) row[4]);

            detalle.add(d);
        }

        factura.setDetalle(detalle);

        return factura;
    }
}
