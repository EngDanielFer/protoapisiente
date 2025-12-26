package com.apisienteproto.protoapisiente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apisienteproto.protoapisiente.models.StockModel;

@Repository
public interface IStockRepository extends JpaRepository<StockModel, Integer> {

    @Procedure(name="p_insertar_stock_producto_ganancias")
    void insertarStockProductoGanancias(
        @Param("prod_id") int prodId,
        @Param("prod_cantidad") int prodCantidad
    );
}
