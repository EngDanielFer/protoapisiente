package com.apisienteproto.protoapisiente.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apisienteproto.protoapisiente.models.FacturaRequestDTO;
import com.apisienteproto.protoapisiente.repositories.FacturaRepository;

@Service
public class FacturaService {

    private final FacturaRepository facturaRepository;

    public FacturaService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    @Transactional
    public int crearfactura(FacturaRequestDTO request) throws Exception {
        return facturaRepository.insertarFactura(
                request.getNombreCliente(),
                request.getApellidoCliente(),
                request.getEmailCliente(),
                request.getDireccionCliente(),
                request.getComplementoDireccion(),
                request.getTelefonoCliente(),
                request.getPaisCliente(),
                request.getRegionCliente(),
                request.getCiudadCliente(),
                request.getProductos(),
                request.getPrecioEnvio(),
                request.getMetodoPago()
        );
    }

}
