package com.apisienteproto.protoapisiente.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apisienteproto.protoapisiente.models.CostosFijosModel;

@Repository
public interface ICostosFijosRepository extends JpaRepository<CostosFijosModel, Integer> {

    Optional<CostosFijosModel> findByIdProducto(int idPoducto);
}
