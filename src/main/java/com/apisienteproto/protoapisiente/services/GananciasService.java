package com.apisienteproto.protoapisiente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apisienteproto.protoapisiente.models.GananciasListadoDTO;
import com.apisienteproto.protoapisiente.repositories.IGananciasRepository;

@Service
public class GananciasService {

    @Autowired
    IGananciasRepository gananciasRepository;

    public List<GananciasListadoDTO> getGanancias() {
        return gananciasRepository.findAll()
            .stream()
            .map(GananciasListadoDTO::new)
            .toList();
    }
}
