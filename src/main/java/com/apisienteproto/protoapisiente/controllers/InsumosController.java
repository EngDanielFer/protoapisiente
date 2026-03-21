package com.apisienteproto.protoapisiente.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apisienteproto.protoapisiente.models.InsumosModel;
import com.apisienteproto.protoapisiente.services.InsumosService;

import lombok.RequiredArgsConstructor;

// localhost:8000/api/siente/insumos
@RestController
@RequestMapping("/api/siente/insumos")
@RequiredArgsConstructor
public class InsumosController {

    private final InsumosService insumosService;

    @GetMapping
    public List<InsumosModel> getInsumos() {
        return this.insumosService.getInsumos();
    }

    @GetMapping("/{id}")
    public InsumosModel getInsumoById(@PathVariable int id) {
        return insumosService.getInsumoById(id);
    }

    @PostMapping
    public ResponseEntity<InsumosModel> saveInsumo(@RequestBody InsumosModel insumo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(insumosService.saveInsumo(insumo));
    }

    @PutMapping("/{id}")
    public InsumosModel updateInsumo(@RequestBody InsumosModel request, @PathVariable int id) {
        return insumosService.updateInsumo(request, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteById(@PathVariable int id) {
        insumosService.deleteInsumo(id);
        return ResponseEntity.ok(Map.of("mensaje", "Insumo eliminado correctamente"));
    }

}
