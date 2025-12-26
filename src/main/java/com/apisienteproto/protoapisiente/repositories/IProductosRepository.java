package com.apisienteproto.protoapisiente.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apisienteproto.protoapisiente.models.ProductosModel;

@Repository
public interface IProductosRepository extends JpaRepository<ProductosModel, Integer> {

    @Procedure(procedureName = "p_insertar_producto_insumos")
    void insertarProductoConInsumos(
            @Param("prod_id") int prodId,
            @Param("prod_nombre") String prodNombre,
            @Param("prod_descripcion") String prodDescripcion,
            @Param("prod_peso") int prodPeso,
            @Param("prod_imagen") byte[] prodImagen,
            @Param("prod_insumos") String prodInsumos,
            @Param("prod_costo_luz") double prodCostoLuz,
            @Param("prod_costo_agua") double prodCostoAgua,
            @Param("prod_costo_gas") double prodCostoGas,
            @Param("prod_costo_aseo") double prodCostoAseo,
            @Param("prod_costo_internet") double prodCostoInternet,
            @Param("prod_costo_mano_obra") double prodCostoManoObra,
            @Param("prod_comentario_mano_obra") String prodComentarioManoObra,
            @Param("prod_costo_transporte") double prodCostoTransporte,
            @Param("prod_costo_perdidas") double prodCostoPerdidas,
            @Param("prod_costo_herramientas") double prodCostoHerramientas,
            @Param("prod_costo_mark_redes") double prodCostoMarkRedes,
            @Param("prod_costo_mark_disenador") double prodCostoMarkDisenador,
            @Param("prod_costo_admin") double prodCostoAdmin,
            @Param("prod_costo_etiqueta") double prodCostoEtiqueta
    );

    @Query(value = "SELECT ip.id_insumo, ip.cantidad_insumo as cantidad "
            + "FROM insumos_por_producto ip "
            + "WHERE ip.id_producto = :productoId",
    nativeQuery=true)
    List<Map<String, Object>> findInsumosByProductoID(@Param("productoId") int productoId);

    @Query(value="SELECT * FROM costos_fijos_productos WHERE id_producto = :productoId",
        nativeQuery=true
    )
    Map<String, Object> findCostosFijosByProudctoId(@Param("productoId") int productoId);
}
