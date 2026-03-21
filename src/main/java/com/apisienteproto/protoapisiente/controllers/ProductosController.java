package com.apisienteproto.protoapisiente.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apisienteproto.protoapisiente.exceptions.RecursoYaExisteException;
import com.apisienteproto.protoapisiente.models.InsumoPorProductoDTO;
import com.apisienteproto.protoapisiente.models.ProductoCompletoDTO;
import com.apisienteproto.protoapisiente.models.ProductosModel;
import com.apisienteproto.protoapisiente.services.InsumosProductoService;
import com.apisienteproto.protoapisiente.services.ProductosService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/siente/productos")
@RequiredArgsConstructor
public class ProductosController {

    private final ProductosService productosService;
    private final InsumosProductoService insumosProductoService;

    @GetMapping
    public List<ProductosModel> getProductos() {
        return productosService.getProductos();
    }

    @GetMapping("/stock")
    public List<ProductosModel> getProductosByStock() {
        return productosService.getProductosByStock();
    }

    @GetMapping("/{id}")
    public ProductosModel getproductoById(@PathVariable int id) {
        return productosService.getProductoById(id);
    }

    @GetMapping("/{id}/completo")
    public ProductoCompletoDTO getProductoCompleto(@PathVariable int id) {
        return productosService.getProductoCompleto(id);
    }

    @GetMapping("/{id}/insumos")
    public List<InsumoPorProductoDTO> getInsumosPorProducto(@PathVariable int id) {
        return insumosProductoService.obtenerInsumosPorProducto(id);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> insertarProducto(@RequestBody ProductoCompletoDTO producto) {
        if (productosService.existeProducto(producto.getId())) {
            throw new RecursoYaExisteException(
                    "El producto con ID " + producto.getId() + " ya existe. Use PUT para actualizar."
            );
        }
        productosService.insertarProductoCompleto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensaje", "Producto creado exitosamente"));
    }

    @PutMapping("/{id}")
    public Map<String, String> actualizarProducto(@PathVariable int id, @RequestBody ProductoCompletoDTO producto) {
        productosService.getProductoById(id);
        producto.setId(id);
        productosService.insertarProductoCompleto(producto);
        return Map.of("mensaje", "Producto actualizado exitosamente");
    }

    @DeleteMapping("/{id}")
    public Map<String, String> eliminarProducto(@PathVariable int id) {
        productosService.eliminarProducto(id);
        return Map.of("mensaje", "Producto eliminado exitosamente");
    }

}
