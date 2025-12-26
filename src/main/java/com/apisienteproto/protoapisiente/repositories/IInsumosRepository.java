package com.apisienteproto.protoapisiente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apisienteproto.protoapisiente.models.InsumosModel;

@Repository
public interface IInsumosRepository extends JpaRepository<InsumosModel, Integer> {

}
