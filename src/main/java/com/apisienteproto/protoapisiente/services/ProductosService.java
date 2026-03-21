package com.apisienteproto.protoapisiente.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apisienteproto.protoapisiente.exceptions.RecursoNoEncontradoException;
import com.apisienteproto.protoapisiente.models.InsumoProductoDTO;
import com.apisienteproto.protoapisiente.models.ProductoCompletoDTO;
import com.apisienteproto.protoapisiente.models.ProductosModel;
import com.apisienteproto.protoapisiente.repositories.IProductosRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductosService {

    private final IProductosRepository productosRepository;
    private final ObjectMapper objectMapper;

    public List<ProductosModel> getProductos() {
        return productosRepository.findAll();
    }

    public List<ProductosModel> getProductosByStock() {
        return productosRepository.findProductosConStock();
    }

    public ProductosModel getProductoById(int id) {
        return productosRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                "Producto no encontrado con ID: " + id
        ));
    }

    @Transactional(readOnly = true)
    public ProductoCompletoDTO getProductoCompleto(int id) {
        ProductosModel producto = getProductoById(id);

        ProductoCompletoDTO dto = new ProductoCompletoDTO();

        dto.setId(producto.getId());
        dto.setNombre_producto(producto.getNombre_producto());
        dto.setDescripcion_producto(producto.getDescripcion_producto());
        dto.setPeso_producto(producto.getPeso_producto());
        dto.setCosto_produccion(producto.getCosto_produccion());
        dto.setGanancia_por_mayor(producto.getGanancia_por_mayor());
        dto.setGanancia_detal(producto.getGanancia_detal());
        dto.setPrecio_por_mayor(producto.getPrecio_por_mayor());
        dto.setPrecio_detal(producto.getPrecio_detal());
        dto.setStock_producto(producto.getStock_producto());
        dto.setImagen_producto(producto.getImagen_producto());

        List<Map<String, Object>> insumosData = productosRepository.findInsumosByProductoID(id);
        List<InsumoProductoDTO> insumos = insumosData.stream()
                .map(data -> {
                    InsumoProductoDTO insumo = new InsumoProductoDTO();
                    insumo.setId_insumo(((Number) data.get("id_insumo")).intValue());
                    insumo.setCantidad(((Number) data.get("cantidad")).doubleValue());
                    return insumo;
                })
                .collect(Collectors.toList());
        dto.setInsumos(insumos);

        Map<String, Object> costosFijos = productosRepository.findCostosFijosByProudctoId(id);
        if (costosFijos != null) {
            dto.setCosto_luz(getDoubleValue(costosFijos.get("costo_luz")));
            dto.setCosto_agua(getDoubleValue(costosFijos.get("costo_agua")));
            dto.setCosto_gas(getDoubleValue(costosFijos.get("costo_gas")));
            dto.setCosto_aseo(getDoubleValue(costosFijos.get("costo_aseo")));
            dto.setCosto_internet(getDoubleValue(costosFijos.get("costo_internet")));
            dto.setCosto_mano_obra(getDoubleValue(costosFijos.get("mano_de_obra")));
            dto.setComentario_mano_obra((String) costosFijos.get("comentario_mano_de_obra"));
            dto.setCosto_transporte(getDoubleValue(costosFijos.get("costo_transporte")));
            dto.setCosto_perdidas(getDoubleValue(costosFijos.get("costo_perdidas")));
            dto.setCosto_herramientas(getDoubleValue(costosFijos.get("costo_herramientas")));
            dto.setCosto_mark_redes(getDoubleValue(costosFijos.get("costo_marketing_redes")));
            dto.setCosto_mark_disenador(getDoubleValue(costosFijos.get("costo_marketing_disenador")));
            dto.setCosto_admin(getDoubleValue(costosFijos.get("costo_admin")));
            dto.setCosto_etiqueta(getDoubleValue(costosFijos.get("costo_etiqueta")));
        }

        return dto;
    }

    private double getDoubleValue(Object value) {
        if (value instanceof Number n) {
            return n.doubleValue();
        }
        return 0.0;
    }

    @Transactional
    public void insertarProductoCompleto(ProductoCompletoDTO producto) {
        try {
            String insumosJson = objectMapper.writeValueAsString(producto.getInsumos());

            productosRepository.insertarProductoConInsumos(
                    producto.getId(),
                    producto.getNombre_producto(),
                    producto.getDescripcion_producto(),
                    producto.getPeso_producto(),
                    producto.getImagen_producto(),
                    insumosJson,
                    producto.getCosto_luz(),
                    producto.getCosto_agua(),
                    producto.getCosto_gas(),
                    producto.getCosto_aseo(),
                    producto.getCosto_internet(),
                    producto.getCosto_mano_obra(),
                    producto.getComentario_mano_obra(),
                    producto.getCosto_transporte(),
                    producto.getCosto_perdidas(),
                    producto.getCosto_herramientas(),
                    producto.getCosto_mark_redes(),
                    producto.getCosto_mark_disenador(),
                    producto.getCosto_admin(),
                    producto.getCosto_etiqueta()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error al insertar producto: " + e.getMessage(), e);
        }
    }

    public boolean existeProducto(int id) {
        return productosRepository.existsById(id);
    }

    @Transactional
    public void eliminarProducto(int id) {
        if (!existeProducto(id)) {
            throw new RecursoNoEncontradoException("Producto no encontrado con ID: " + id);
        }
        productosRepository.deleteById(id);
    }
}
