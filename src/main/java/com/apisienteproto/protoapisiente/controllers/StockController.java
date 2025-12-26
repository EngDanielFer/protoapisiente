package com.apisienteproto.protoapisiente.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apisienteproto.protoapisiente.models.StockListadoDTO;
import com.apisienteproto.protoapisiente.models.StockModel;
import com.apisienteproto.protoapisiente.models.StockRequestDTO;
import com.apisienteproto.protoapisiente.models.StockResponseDTO;
import com.apisienteproto.protoapisiente.services.StockService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/siente/stock")
@Validated
@CrossOrigin(origins="http://localhost:4200")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public List<StockListadoDTO> getStock() {
        return stockService.getStock();
    }

    @PostMapping
    public ResponseEntity<StockResponseDTO> insertarStock(@Valid @RequestBody StockRequestDTO request) {
        try {
            stockService.insertarStockProducto(request.getId_producto(), request.getCantidad_producto());

            return ResponseEntity.ok(
                new StockResponseDTO(true, "Se ha insertado el stock")
            );
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                .badRequest()
                .body(new StockResponseDTO(false, e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new StockResponseDTO(
                    false, 
                    "Error al procesar la solicitud: " + e.getMessage()
                ));
        }
    }

}
