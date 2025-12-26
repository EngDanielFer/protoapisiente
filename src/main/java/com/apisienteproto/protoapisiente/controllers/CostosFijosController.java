package com.apisienteproto.protoapisiente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apisienteproto.protoapisiente.models.CostoFijoItemDTO;
import com.apisienteproto.protoapisiente.services.CostosFijosService;

@RestController
@RequestMapping("/api/siente/productos")
@CrossOrigin(origins="http://localhost:4200")
public class CostosFijosController {

    @Autowired
    private CostosFijosService costosFijosService;

    @GetMapping("/{id}/costos-fijos")
    public ResponseEntity<List<CostoFijoItemDTO>> getCostosFijosByProducto(@PathVariable int id) {
        try {
            List<CostoFijoItemDTO> costosFijos = costosFijosService.getCostosFijosByProducto(id);
            return ResponseEntity.ok(costosFijos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
