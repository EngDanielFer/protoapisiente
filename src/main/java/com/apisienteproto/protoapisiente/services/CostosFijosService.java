package com.apisienteproto.protoapisiente.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.apisienteproto.protoapisiente.models.CostoFijoItemDTO;
import com.apisienteproto.protoapisiente.models.CostosFijosModel;
import com.apisienteproto.protoapisiente.repositories.ICostosFijosRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CostosFijosService {

    private final ICostosFijosRepository costosFijosRepository;

    public List<CostoFijoItemDTO> getCostosFijosByProducto(int idProducto) {
        Optional<CostosFijosModel> opt = costosFijosRepository.findById(idProducto);

        List<CostoFijoItemDTO> lista = new ArrayList<>();

        if (opt.isEmpty()) {
            return lista;
        }

        CostosFijosModel c = opt.get();

        agregarSiPositivo(lista, "Luz", c.getCostoLuz());
        agregarSiPositivo(lista, "Agua", c.getCostoAgua());
        agregarSiPositivo(lista, "Gas", c.getCostoGas());
        agregarSiPositivo(lista, "Aseo", c.getCostoAseo());
        agregarSiPositivo(lista, "Internet", c.getCostoInternet());
        agregarSiPositivo(lista, "Mano de obra", c.getManoDeObra());
        agregarSiPositivo(lista, "Transporte", c.getCostoTransporte());
        agregarSiPositivo(lista, "Pérdidas", c.getCostoPerdidas());
        agregarSiPositivo(lista, "Herramientas", c.getCostoHerramientas());
        agregarSiPositivo(lista, "Marketing Redes Sociales", c.getCostoMarketingRedes());
        agregarSiPositivo(lista, "Marketing Diseñador", c.getCostoMarketingDisenador());
        agregarSiPositivo(lista, "Administración", c.getCostoAdmin());
        agregarSiPositivo(lista, "Etiqueta", c.getCostoEtiqueta());

        return lista;
    }

    private void agregarSiPositivo(List<CostoFijoItemDTO> lista, String nombre, double valor) {
        if (valor > 0) {
            lista.add(new CostoFijoItemDTO(nombre, valor));
        }
    }

}
