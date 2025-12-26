package com.apisienteproto.protoapisiente.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apisienteproto.protoapisiente.models.InsumoPorProductoDTO;
import com.apisienteproto.protoapisiente.models.InsumoPorProductoId;
import com.apisienteproto.protoapisiente.models.InsumosProductoModel;

@Repository
public interface IInsumosProductosRepository extends JpaRepository<InsumosProductoModel, InsumoPorProductoId> {

    @Query("""
            SELECT new com.apisienteproto.protoapisiente.models.InsumoPorProductoDTO(
                ipp.idInsumo,
                i.nombre_insumo,
                ipp.cantidadInsumo,
                ipp.precioInsumo
            )
            FROM InsumosProductoModel ipp
            JOIN InsumosModel i ON i.id = ipp.idInsumo
            WHERE ipp.idProducto = :idProducto
    """)
    List<InsumoPorProductoDTO> findInsumosByProducto(@Param("idProducto") int idProducto);
}
