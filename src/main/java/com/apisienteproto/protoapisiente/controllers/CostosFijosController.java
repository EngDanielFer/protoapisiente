package com.apisienteproto.protoapisiente.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apisienteproto.protoapisiente.models.CostoFijoItemDTO;
import com.apisienteproto.protoapisiente.services.CostosFijosService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/siente/productos")
@RequiredArgsConstructor
public class CostosFijosController {

    private final CostosFijosService costosFijosService;

    @GetMapping("/{id}/costos-fijos")
    public List<CostoFijoItemDTO> getCostosFijosByProducto(@PathVariable int id) {
        return costosFijosService.getCostosFijosByProducto(id);
    }

}
