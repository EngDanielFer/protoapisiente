package com.apisienteproto.protoapisiente.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apisienteproto.protoapisiente.models.GananciasListadoDTO;
import com.apisienteproto.protoapisiente.services.GananciasService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/siente/ganancias")
@RequiredArgsConstructor
public class GananciasController {

    private final GananciasService gananciasService;

    @GetMapping
    public List<GananciasListadoDTO> getGanancias() {
        return gananciasService.getGanancias();
    }
}
