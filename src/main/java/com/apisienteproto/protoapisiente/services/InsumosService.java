package com.apisienteproto.protoapisiente.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.apisienteproto.protoapisiente.exceptions.RecursoNoEncontradoException;
import com.apisienteproto.protoapisiente.models.InsumosModel;
import com.apisienteproto.protoapisiente.repositories.IInsumosRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InsumosService {

    private final IInsumosRepository insumosRepository;

    public List<InsumosModel> getInsumos() {
        return insumosRepository.findAll();
    }

    public InsumosModel getInsumoById(int id) {
        return insumosRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                "No se encontró el insumo con ID: " + id
        ));
    }

    @Transactional
    public InsumosModel saveInsumo(InsumosModel insumo) {
        if (insumo.getEstado_insumo() == null || insumo.getEstado_insumo().isEmpty()) {
            insumo.setEstado_insumo("Disponible");
        }

        if (insumo.getCantidad_insumo_restante() == null) {
            insumo.setCantidad_insumo_restante(insumo.getCantidad_insumo_total());
        }

        return insumosRepository.save(insumo);
    }

    @Transactional
    public InsumosModel updateInsumo(InsumosModel request, int id) {
        InsumosModel insumo = getInsumoById(id);

        if (request.getNombre_insumo() != null && !request.getNombre_insumo().isBlank()) {
            insumo.setNombre_insumo(request.getNombre_insumo());
        }

        if (request.getCantidad_insumo_total() != null && request.getCantidad_insumo_total().compareTo(BigDecimal.ZERO) >= 0) {
            insumo.setCantidad_insumo_total(request.getCantidad_insumo_total());
        }

        if (request.getCantidad_insumo_restante() != null && request.getCantidad_insumo_restante().compareTo(BigDecimal.ZERO) >= 0) {
            insumo.setCantidad_insumo_restante(request.getCantidad_insumo_total());
        }

        if (request.getProveedor_insumo() != null && !request.getProveedor_insumo().isBlank()) {
            insumo.setProveedor_insumo(request.getProveedor_insumo());
        }

        if (request.getPrecio_insumo() != null && request.getPrecio_insumo().compareTo(BigDecimal.ZERO) > 0) {
            insumo.setPrecio_insumo(request.getPrecio_insumo());
        }

        if (request.getPrecio_por_g_ml() != null && request.getPrecio_por_g_ml().compareTo(BigDecimal.ZERO) > 0) {
            insumo.setPrecio_por_g_ml(request.getPrecio_por_g_ml());
        }

        if (request.getEstado_insumo() != null && !request.getEstado_insumo().isBlank()) {
            insumo.setEstado_insumo(request.getEstado_insumo());
        }

        return insumosRepository.save(insumo);
    }

    @Transactional
    public void deleteInsumo(int id) {
        if (!insumosRepository.existsById(id)) {
            throw new RecursoNoEncontradoException(
                    "No se encontró el insumo con ID: " + id
            );
        }

        insumosRepository.deleteById(id);
    }

}
