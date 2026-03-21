package com.apisienteproto.protoapisiente.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apisienteproto.protoapisiente.models.StockListadoDTO;
import com.apisienteproto.protoapisiente.repositories.IStockRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class StockService {

    private final IStockRepository stockRepository;

    @Transactional(readOnly = true)
    public List<StockListadoDTO> getStock() {
        return stockRepository.findAll()
            .stream()
            .map(StockListadoDTO::new)
            .toList();
    }

    @Transactional
    public void insertarStockProducto(int idProducto, int cantidadProducto) throws SQLException {
        try {
            stockRepository.insertarStockProductoGanancias(idProducto, cantidadProducto);
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
                    throw new IllegalArgumentException("No hay insumos definidos para este producto");
                } else if (msjError.contains("No hay suficiente insumo")) {
                    throw new IllegalArgumentException("Stock de insumos insuficiente");
                }
            }
            log.error("Error al insertar stock: {}", msjError, e);
            throw new RuntimeException("Error al procesar el stock", e);
        }
    }

}
