package com.apisienteproto.protoapisiente.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apisienteproto.protoapisiente.models.StockListadoDTO;
import com.apisienteproto.protoapisiente.models.StockRequestDTO;
import com.apisienteproto.protoapisiente.models.StockResponseDTO;
import com.apisienteproto.protoapisiente.services.StockService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/siente/stock")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping
    public List<StockListadoDTO> getStock() {
        return stockService.getStock();
    }

    @PostMapping
    public ResponseEntity<StockResponseDTO> insertarStock(@Valid @RequestBody StockRequestDTO request) {
        try {
            stockService.insertarStockProducto(request.getId_producto(), request.getCantidad_producto());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(
                new StockResponseDTO(true, "Se ha insertado el stock exitosamente")
        );
    }

}
