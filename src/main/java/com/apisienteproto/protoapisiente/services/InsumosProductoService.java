package com.apisienteproto.protoapisiente.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.apisienteproto.protoapisiente.models.InsumoPorProductoDTO;
import com.apisienteproto.protoapisiente.repositories.IInsumosProductosRepository;

@Service
public class InsumosProductoService {

    private final IInsumosProductosRepository insumosProductosRepository;

    public InsumosProductoService(IInsumosProductosRepository insumosProductosRepository) {
        this.insumosProductosRepository = insumosProductosRepository;
    }

    public List<InsumoPorProductoDTO> obtenerInsumosPorProducto(int idProducto) {
        return insumosProductosRepository.findInsumosByProducto(idProducto);
    }
}
