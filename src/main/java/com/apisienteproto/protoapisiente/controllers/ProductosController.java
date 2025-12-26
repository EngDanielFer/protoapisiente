package com.apisienteproto.protoapisiente.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apisienteproto.protoapisiente.models.InsumoPorProductoDTO;
import com.apisienteproto.protoapisiente.models.ProductoCompletoDTO;
import com.apisienteproto.protoapisiente.models.ProductosModel;
import com.apisienteproto.protoapisiente.services.InsumosProductoService;
import com.apisienteproto.protoapisiente.services.ProductosService;


@RestController
@RequestMapping("/api/siente/productos")
@CrossOrigin(origins = {
    "http://localhost:4200", 
    "http://localhost:4300"
})
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    private final InsumosProductoService insumosProductoService;

    public ProductosController(InsumosProductoService insumosProductoService) {
        this.insumosProductoService = insumosProductoService;
    }

    @GetMapping
    public ArrayList<ProductosModel> getProductos() {
        return this.productosService.getProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getproductoById(@PathVariable int id) {
        return this.productosService.getProductoById(id)
                .map(producto -> ResponseEntity.ok(producto))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @GetMapping("/{id}/completo")
    public ResponseEntity<?> getProductoCompleto(@PathVariable int id) {
        try {
            ProductoCompletoDTO producto = this.productosService.getProductoCompleto(id);
            return ResponseEntity.ok(producto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Producto no encontrado: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener el producto: " + e.getMessage());
        }
    }

    @GetMapping("/{id}/insumos")
    public ResponseEntity<List<InsumoPorProductoDTO>> getInsumosPorProducto(@PathVariable int id) {
        return ResponseEntity.ok(insumosProductoService.obtenerInsumosPorProducto(id));
    }
    

    @PostMapping
    public ResponseEntity<String> insertarProducto(@RequestBody ProductoCompletoDTO producto) {
        try {
            if (this.productosService.existeProducto(producto.getId())) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("El producto con ID " + producto.getId() + " ya existe. Use PUT para actualizar.");
            }
            this.productosService.insertarProductoCompleto(producto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Se ha insertado exitosamente el producto");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al insertar el producto: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarProducto(@PathVariable int id, @RequestBody ProductoCompletoDTO producto) {
        try {
            if (!this.productosService.existeProducto(id)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("El producto con ID " + id + " no existe. Use POST para crear uno nuevo.");
            }

            producto.setId(id);
            this.productosService.insertarProductoCompleto(producto);
            return ResponseEntity.ok("Producto actualizado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar el producto: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable int id) {
        try {
            if (!this.productosService.existeProducto(id)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El producto con ID " + id + " no existe.");
            }

            this.productosService.eliminarProducto(id);
            return ResponseEntity.ok("Producto eliminado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al eliminar el producto: " + e.getMessage());
        }
    }

}
