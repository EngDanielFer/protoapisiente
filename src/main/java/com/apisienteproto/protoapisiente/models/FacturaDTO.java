package com.apisienteproto.protoapisiente.models;

import java.math.BigDecimal;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacturaDTO {

    @Valid
    @NotNull(message = "Los datos del cliente son requeridos")
    private DatosClienteDTO datosCliente;

    @NotNull(message = "La lista de productos es requerida")
    @Size(min = 1, message = "Debe incluir al menos un producto")
    @Valid
    private List<ProductoFacturaDTO> productos;

    @NotNull(message = "El precio de envío es requerido")
    @DecimalMin(value = "0.0", inclusive = true, message = "El precio de envío no puede ser negativo")
    private BigDecimal precio_envio;

    @NotBlank(message = "El método de pago es requerido")
    @Size(max = 30, message = "El método de pago no puede exceder 30 caracteres")
    private String metodo_pago;

    @NotBlank(message = "El tipo de precio es requerido")
    @Pattern(regexp = "^(mayor|detal)$", message = "El tipo de precio debe ser 'mayor' o 'detal'")
    private String tipo_precio;
}
