package com.apisienteproto.protoapisiente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apisienteproto.protoapisiente.models.GananciasListadoDTO;
import com.apisienteproto.protoapisiente.services.GananciasService;

@RestController
@RequestMapping("api/siente/ganancias")
@CrossOrigin(origins="http://localhost:4200")
public class GananciasController {

    @Autowired
    private GananciasService gananciasService;

    @GetMapping
    public List<GananciasListadoDTO> getGanancias() {
        return gananciasService.getGanancias();
    }
}
