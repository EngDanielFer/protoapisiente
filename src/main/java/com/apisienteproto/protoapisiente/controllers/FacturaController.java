package com.apisienteproto.protoapisiente.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Slf4j
public class FacturaController {

    private final FacturaService facturaService;
    private final FacturaConsultaService facturaConsultaService;

    // public FacturaController(FacturaService facturaService, FacturaConsultaService facturaConsultaService) {
    //     this.facturaService = facturaService;
    //     this.facturaConsultaService = facturaConsultaService;
    // }
    @PostMapping
    public ResponseEntity<?> crearFactura(@Valid @RequestBody FacturaDTO facturaDTO) {
        try {
            // int idFactura = facturaService.crearfactura(request);

            // return ResponseEntity.status(HttpStatus.CREATED)
            //         .body(Map.of(
            //                 "mensaje", "Factura creada correctamente",
            //                 "idFactura", idFactura
            //         ));
            log.info("Recibida petición para crear factura");
            log.debug("Datos recibidos: {}", facturaDTO);

            FacturaResponseDTO response = facturaService.crearFactura(facturaDTO);

            log.info("Factura creada exitosamente con ID: {}", response.getId_factura());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            log.error("Error de validación: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(createErrorResponse(e.getMessage()));
        } catch (RuntimeException e) {
            log.error("Error al crear factura: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(createErrorResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of(
                            "error", e.getMessage()
                    ));
        }
    }

    // @GetMapping
    // public ResponseEntity<List<FacturaResponseDTO>> listarFacturas() {
    //     return ResponseEntity.ok(facturaConsultaService.listarFacturas());
    // }
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerFactura(@PathVariable Integer id) {
        try {
            log.info("Buscando factura con ID: {}", id);

            FacturaCompletaDTO factura = facturaConsultaService.obtenerFacturaCompleta(id);

            log.info("Factura encontrada: {}", id);
            return ResponseEntity.ok(factura);

        } catch (RuntimeException e) {
            log.error("Error al obtener factura {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(createErrorResponse(e.getMessage()));

        } catch (Exception e) {
            log.error("Error inesperado al obtener factura {}: {}", id, e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(createErrorResponse("Error interno del servidor"));
        }
    }
    // public ResponseEntity<FacturaCompletaDTO> obtenerFactura(@PathVariable int id) {
    //     return ResponseEntity.ok(facturaConsultaService.obtenerFacturaCompleta(id));
    // }

    @GetMapping
    public ResponseEntity<?> obtenerTodasFacturas() {
        try {
            log.info("Obteniendo todas las facturas");

            List<FacturaCompletaDTO> facturas = facturaConsultaService.listarFacturasCompletas();

            log.info("Se encontraron {} facturas", facturas.size());
            return ResponseEntity.ok(facturas);

        } catch (Exception e) {
            log.error("Error al obtener facturas: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(createErrorResponse("Error al obtener las facturas"));
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> obtenerFacturasPorEmail(@PathVariable String email) {
        try {
            log.info("Buscando facturas para email: {}", email);

            List<Factura> facturas = facturaService.obtenerFacturasPorEmail(email);

            log.info("Se encontraron {} facturas para el email {}", facturas.size(), email);
            return ResponseEntity.ok(facturas);

        } catch (Exception e) {
            log.error("Error al buscar facturas por email {}: {}", email, e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(createErrorResponse("Error al buscar las facturas"));
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(
            MethodArgumentNotValidException ex
    ) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        log.warn("Errores de validación: {}", errors);

        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Errores de validación");
        response.put("errores", errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGenericException(Exception ex) {
        log.error("Error no controlado: {}", ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(createErrorResponse("Error interno del servidor"));
    }

    private Map<String, String> createErrorResponse(String mensaje) {
        Map<String, String> error = new HashMap<>();
        error.put("mensaje", mensaje);
        return error;
    }

}
