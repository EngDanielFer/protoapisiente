package com.apisienteproto.protoapisiente.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apisienteproto.protoapisiente.models.GananciasListadoDTO;
import com.apisienteproto.protoapisiente.repositories.IGananciasRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GananciasService {

    private final IGananciasRepository gananciasRepository;

    @Transactional(readOnly = true)
    public List<GananciasListadoDTO> getGanancias() {
        return gananciasRepository.findAll()
                .stream()
                .map(GananciasListadoDTO::new)
                .toList();
    }
}
