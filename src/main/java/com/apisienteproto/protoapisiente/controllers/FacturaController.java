package com.apisienteproto.protoapisiente.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apisienteproto.protoapisiente.models.FacturaCompletaDTO;
import com.apisienteproto.protoapisiente.models.FacturaRequestDTO;
import com.apisienteproto.protoapisiente.models.FacturaResponseDTO;
import com.apisienteproto.protoapisiente.services.FacturaConsultaService;
import com.apisienteproto.protoapisiente.services.FacturaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/siente/facturas")
@CrossOrigin(origins = "*")
public class FacturaController {

    private final FacturaService facturaService;
    private final FacturaConsultaService facturaConsultaService;

    public FacturaController(FacturaService facturaService, FacturaConsultaService facturaConsultaService) {
        this.facturaService = facturaService;
        this.facturaConsultaService = facturaConsultaService;
    }

    @PostMapping
    public ResponseEntity<?> crearFactura(@RequestBody FacturaRequestDTO request) {
        try {
            int idFactura = facturaService.crearfactura(request);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(Map.of(
                            "mensaje", "Factura creada correctamente",
                            "idFactura", idFactura
                    ));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of(
                            "error", e.getMessage()
                    ));
        }
    }

    @GetMapping
    public ResponseEntity<List<FacturaResponseDTO>> listarFacturas() {
        return ResponseEntity.ok(facturaConsultaService.listarFacturas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaCompletaDTO> obtenerFactura(@PathVariable int id) {
        return ResponseEntity.ok(facturaConsultaService.obtenerFacturaCompleta(id));
    }

}
