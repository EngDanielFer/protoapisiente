package com.apisienteproto.protoapisiente.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

// localhost:8000/api/siente/insumos
@RestController
@RequestMapping("/api/siente/insumos")
@CrossOrigin(origins="http://localhost:4200")
public class InsumosController {

    @Autowired
    private InsumosService insumosService;

    @GetMapping
    public ArrayList<InsumosModel> getInsumos() {
        return this.insumosService.getInsumos();
    }

    // @GetMapping(path="/{id}")
    // public Optional<InsumosModel> getInsumoById(@PathVariable("id") int id) {
    //     return this.insumosService.getInsumoById(id);
    // }

    @GetMapping(path="/{id}")
    public ResponseEntity<?> getInsumoById(@PathVariable("id") int id) {
        return this.insumosService.getInsumoById(id);
    }

    @PostMapping
    public InsumosModel saveInsumo(@RequestBody InsumosModel insumo) {
        return this.insumosService.saveInsumo(insumo);
    }

    @PutMapping(path="/{id}")
    public InsumosModel updateInsumoById(@RequestBody InsumosModel request, @PathVariable("id") int id) {
        return this.insumosService.updateInsumo(request, id);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
        // boolean ok = this.insumosService.deleteInsumo(id);

        // if (ok) {
        //     return "Se ha eliminado el insumo con el id: " + id;
        // } else {
        //     return "Error al eliminar el insumo con el id: " + id;
        // }
        return this.insumosService.deleteInsumo(id);
    }

}
