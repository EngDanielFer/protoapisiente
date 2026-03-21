package com.apisienteproto.protoapisiente.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apisienteproto.protoapisiente.models.Factura;
import com.apisienteproto.protoapisiente.models.FacturaCompletaDTO;
import com.apisienteproto.protoapisiente.models.FacturaDTO;
import com.apisienteproto.protoapisiente.models.FacturaResponseDTO;
import com.apisienteproto.protoapisiente.services.FacturaConsultaService;
import com.apisienteproto.protoapisiente.services.FacturaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// import org.springframework.web.bind.annotation.RequestParam;
@RestController
@RequestMapping("/api/siente/facturas")
@RequiredArgsConstructor
@Slf4j
public class FacturaController {

    private final FacturaService facturaService;
    private final FacturaConsultaService facturaConsultaService;

    @PostMapping
    public ResponseEntity<FacturaResponseDTO> crearFactura(@Valid @RequestBody FacturaDTO facturaDTO) {
        log.info("Creando factura para: {}", facturaDTO.getDatosCliente().getEmail_cliente());
        FacturaResponseDTO response = facturaService.crearFactura(facturaDTO);

        log.info("Factura creada exitosamente con ID: {}", response.getId_factura());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public List<FacturaCompletaDTO> obtenerTodasFacturas() {
        return facturaConsultaService.listarFacturasCompletas();
    }

    @GetMapping("/{id}")
    public FacturaCompletaDTO obtenerFactura(@PathVariable Integer id) {
        return facturaConsultaService.obtenerFacturaCompleta(id);
    }

    @GetMapping("/email/{email}")
    public List<Factura> obtenerFacturasPorEmail(@PathVariable String email) {
        return facturaService.obtenerFacturasPorEmail(email);
    }

}
