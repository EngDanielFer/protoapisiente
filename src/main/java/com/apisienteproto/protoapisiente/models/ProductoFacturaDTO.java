package com.apisienteproto.protoapisiente.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoFacturaDTO {

    @NotNull(message = "El ID del producto es requerido")
    @Positive(message = "El ID del producto debe ser positivo")
    private int id_producto;

    @NotNull(message = "La cantidad del producto es requerida")
    @Positive(message = "La cantidad debe ser mayor a 0")
    private int cantidad_producto;
}
