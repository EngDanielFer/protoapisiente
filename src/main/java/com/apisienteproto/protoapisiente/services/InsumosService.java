package com.apisienteproto.protoapisiente.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.apisienteproto.protoapisiente.models.InsumosModel;
import com.apisienteproto.protoapisiente.repositories.IInsumosRepository;

import jakarta.persistence.PrePersist;

@Service
public class InsumosService {

    @Autowired
    IInsumosRepository insumosRepository;

    public ArrayList<InsumosModel> getInsumos() {
        return (ArrayList<InsumosModel>) insumosRepository.findAll();
    }

    // public Optional<InsumosModel> getInsumoById(int id) {
    //     return insumosRepository.findById(id);
    // }

    public ResponseEntity<?> getInsumoById(@PathVariable int id) {
        return insumosRepository.findById(id)
            .<ResponseEntity<?>>map(insumo -> ResponseEntity.ok(insumo))
            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("No se ha encontado el insumo con el ID: " + id));
    }

    @PrePersist
    public InsumosModel saveInsumo(InsumosModel insumo) {
        if (insumo.getEstado_insumo() == null || insumo.getEstado_insumo().isEmpty()) {
            insumo.setEstado_insumo("Disponible");
        }

        if (insumo.getCantidad_insumo_restante() == null) {
            insumo.setCantidad_insumo_restante(insumo.getCantidad_insumo_total());
        }

        return insumosRepository.save(insumo);
    }

    public InsumosModel updateInsumo(InsumosModel request, int id) {
        InsumosModel insumo = insumosRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No se ha encontrado el insumo con el id " + id));
        
        if (request.getNombre_insumo() != null && !request.getNombre_insumo().isEmpty()) {
            insumo.setNombre_insumo(request.getNombre_insumo());
        }

        if (request.getCantidad_insumo_total() != null && request.getCantidad_insumo_total().compareTo(BigDecimal.ZERO) > 0) {
            // BigDecimal cantAnterior = insumo.getCantidad_insumo_total();
            // BigDecimal nuevaCant = ;

            // BigDecimal difCant = nuevaCant.subtract(cantAnterior);
            // BigDecimal nuevaCantRest = insumo.getCantidad_insumo_restante().add(difCant);

            insumo.setCantidad_insumo_total(request.getCantidad_insumo_total());
        }

        if (request.getCantidad_insumo_restante() != null && request.getCantidad_insumo_restante().compareTo(BigDecimal.ZERO) > 0) {
            insumo.setCantidad_insumo_restante(request.getCantidad_insumo_total());
        }

        if (request.getProveedor_insumo() != null && !request.getProveedor_insumo().isEmpty()) {
            insumo.setProveedor_insumo(request.getProveedor_insumo());
        }

        if (request.getPrecio_insumo() != null && request.getPrecio_insumo().compareTo(BigDecimal.ZERO) > 0) {
            insumo.setPrecio_insumo(request.getPrecio_insumo());
        }

        if (request.getPrecio_por_g_ml() != null && request.getPrecio_por_g_ml().compareTo(BigDecimal.ZERO) > 0) {
            insumo.setPrecio_por_g_ml(request.getPrecio_por_g_ml());
        }

        if (request.getEstado_insumo() != null && !request.getEstado_insumo().isEmpty()) {
            insumo.setEstado_insumo(request.getEstado_insumo());
        }

        return insumosRepository.save(insumo);
    }

    // public boolean deleteInsumo(int id) {
    //     try {
    //         insumosRepository.deleteById(id);
    //         return true;
    //     } catch (Exception e) {
    //         return false;
    //     }
    // }

    public ResponseEntity<?> deleteInsumo(int id) {
        if (!insumosRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", "No se encuentra el insumo con el ID: " + id));
        }

        insumosRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK)
            .body(Map.of("message", "Se ha borrado el insumo con el ID: " + id));
    }

}
