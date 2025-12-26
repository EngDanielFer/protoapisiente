package com.apisienteproto.protoapisiente.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apisienteproto.protoapisiente.models.CostoFijoItemDTO;
import com.apisienteproto.protoapisiente.models.CostosFijosModel;
import com.apisienteproto.protoapisiente.repositories.ICostosFijosRepository;

@Service
public class CostosFijosService {

    @Autowired
    ICostosFijosRepository costosFijosRepository;

    public ArrayList<CostosFijosModel> getCostosFijos() {
        return (ArrayList<CostosFijosModel>) costosFijosRepository.findAll();
    }

    public List<CostoFijoItemDTO> getCostosFijosByProducto(int idProducto) {
        Optional<CostosFijosModel> costosFijosOpt = costosFijosRepository.findById(idProducto);

        List<CostoFijoItemDTO> listaCostos = new ArrayList<>();

        if (costosFijosOpt.isPresent()) {
            CostosFijosModel costos = costosFijosOpt.get();

            if (costos.getCostoLuz() > 0) {
                listaCostos.add(new CostoFijoItemDTO(
                    "Luz",
                    costos.getCostoLuz()
                ));
            }

            if (costos.getCostoAgua() > 0) {
                listaCostos.add(new CostoFijoItemDTO(
                    "Agua",
                    costos.getCostoAgua()
                ));
            }

            if(costos.getCostoGas() > 0) {
                listaCostos.add(new CostoFijoItemDTO(
                    "Gas",
                    costos.getCostoGas()
                ));
            }

            if(costos.getCostoAseo() > 0) {
                listaCostos.add(new CostoFijoItemDTO(
                    "Aseo",
                    costos.getCostoAseo()
                ));
            }

            if(costos.getCostoInternet() > 0) {
                listaCostos.add(new CostoFijoItemDTO(
                    "Internet",
                    costos.getCostoInternet()
                ));
            }

            if(costos.getManoDeObra() > 0) {
                listaCostos.add(new CostoFijoItemDTO(
                    "Mano de obra",
                    costos.getManoDeObra()
                ));
            }

            if(costos.getCostoTransporte() > 0) {
                listaCostos.add(new CostoFijoItemDTO(
                    "Transporte",
                    costos.getCostoTransporte()
                ));
            }

            if(costos.getCostoPerdidas() > 0) {
                listaCostos.add(new CostoFijoItemDTO(
                    "Pérdidas",
                    costos.getCostoPerdidas()
                ));
            }

            if(costos.getCostoHerramientas() > 0) {
                listaCostos.add(new CostoFijoItemDTO(
                    "Herramientas",
                    costos.getCostoHerramientas()
                ));
            }

            if(costos.getCostoMarketingRedes() > 0) {
                listaCostos.add(new CostoFijoItemDTO(
                    "Marketing Redes Sociales",
                    costos.getCostoMarketingRedes()
                ));
            }

            if(costos.getCostoMarketingDisenador() > 0) {
                listaCostos.add(new CostoFijoItemDTO(
                    "Marketing Diseñador",
                    costos.getCostoMarketingDisenador()
                ));
            }

            if(costos.getCostoAdmin() > 0) {
                listaCostos.add(new CostoFijoItemDTO(
                    "Administración",
                    costos.getCostoAdmin()
                ));
            }

            if(costos.getCostoEtiqueta() > 0) {
                listaCostos.add(new CostoFijoItemDTO(
                    "Etiqueta",
                    costos.getCostoEtiqueta()
                ));
            }
        }

        return listaCostos;
    }

}
