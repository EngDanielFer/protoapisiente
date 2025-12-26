package com.apisienteproto.protoapisiente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apisienteproto.protoapisiente.models.GananciasModel;

@Repository
public interface IGananciasRepository extends JpaRepository<GananciasModel, Integer> {

}
