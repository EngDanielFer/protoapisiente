package com.apisienteproto.protoapisiente.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apisienteproto.protoapisiente.models.StockListadoDTO;
import com.apisienteproto.protoapisiente.repositories.IStockRepository;

@Service
public class StockService {

    @Autowired
    private IStockRepository stockRepository;

    public List<StockListadoDTO> getStock() {
        return stockRepository.findAll()
            .stream()
            .map(StockListadoDTO::new)
            .toList();
    }

    @Transactional(rollbackFor=Exception.class)
    public void insertarStockProducto(int id_producto, int cantidad_producto) throws SQLException {
        try {
            stockRepository.insertarStockProductoGanancias(id_producto, cantidad_producto);
        } catch (Exception e) {
            String msjError = e.getMessage();
            if (msjError != null) {
                if (msjError.contains("ID de producto inválido")) {
                    throw new IllegalArgumentException("ID de producto inválido");
                } else if (msjError.contains("La cantidad debe ser mayor a 0")) {
                    throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
                } else if (msjError.contains("No existe el producto")) {
                    throw new IllegalArgumentException("No existe el producto");
                } else if (msjError.contains("No hay insumos definidos")) {
                    throw new IllegalArgumentException("No hay insumos definidos");
                } else if (msjError.contains("No hay suficiente insumo")) {
                    throw new IllegalArgumentException("No hay suficiente insumo");
                }
            }
            throw new SQLException("Error al insertar stock: " + msjError, e);
        }
    }

}
