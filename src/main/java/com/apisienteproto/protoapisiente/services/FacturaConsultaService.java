package com.apisienteproto.protoapisiente.services;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.apisienteproto.protoapisiente.models.FacturaCompletaDTO;
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

            dto.setId((int) row[0]);
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

    public FacturaCompletaDTO obtenerFacturaCompleta(int id) {

        Object[] f = repository.obtenerFacturaPorId(id);
        List<Object[]> detalleRows = repository.obtenerDetalleFactura(id);

        FacturaCompletaDTO factura = new FacturaCompletaDTO();

        factura.setId((Integer) f[0]);
        factura.setFecha(((Timestamp) f[1]).toLocalDateTime());
        factura.setNombreCliente((String) f[2]);
        factura.setApellidoCliente((String) f[3]);
        factura.setEmailCliente((String) f[4]);
        factura.setDireccionCliente((String) f[5]);
        factura.setComplementoDireccion((String) f[6]);
        factura.setTelefonoCliente((String) f[7]);
        factura.setPaisCliente((String) f[8]);
        factura.setRegionCliente((String) f[9]);
        factura.setCiudadCliente((String) f[10]);
        factura.setValorPagado((BigDecimal) f[11]);
        factura.setPrecioEnvio((BigDecimal) f[12]);
        factura.setValorTotal((BigDecimal) f[13]);
        factura.setMetodoPago((String) f[14]);

        List<FacturaDetalleDTO> detalle = new ArrayList<>();

        for (Object[] d : detalleRows) {
            FacturaDetalleDTO det = new FacturaDetalleDTO();
            det.setIdProducto((Integer) d[0]);
            det.setNombreProducto((String) d[1]);
            det.setCantidadProducto((Integer) d[2]);
            det.setPrecioUnitario((BigDecimal) d[3]);
            det.setSubtotal((BigDecimal) d[4]);
            detalle.add(det);
        }

        factura.setDetalle(detalle);
        return factura;
    }
}
