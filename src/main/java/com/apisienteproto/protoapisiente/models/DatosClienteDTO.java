package com.apisienteproto.protoapisiente.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatosClienteDTO {

    @NotBlank(message = "El nombre del cliente es requerido")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String nombre_cliente;

    @NotBlank(message = "El apellido del cliente es requerido")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
    private String apellido_cliente;

    @NotBlank(message = "El email del cliente es requerido")
    @Email(message = "Email inválido")
    @Size(max = 100, message = "El email no puede exceder 100 caracteres")
    private String email_cliente;

    @NotBlank(message = "La dirección del cliente es requerida")
    @Size(max = 100, message = "La dirección no puede exceder 100 caracteres")
    private String direccion_cliente;

    @Size(max = 100, message = "El complemento no puede exceder 100 caracteres")
    private String complemento_direccion;

    @NotBlank(message = "El teléfono del cliente es requerido")
    @Size(max = 20, message = "El teléfono no puede exceder 20 caracteres")
    private String telefono_cliente;

    @NotBlank(message = "El país del cliente es requerido")
    @Size(max = 50, message = "El país no puede exceder 50 caracteres")
    private String pais_cliente;

    @NotBlank(message = "La región del cliente es requerida")
    @Size(max = 30, message = "La región no puede exceder 30 caracteres")
    private String region_cliente;

    @NotBlank(message = "La ciudad del cliente es requerida")
    @Size(max = 30, message = "La ciudad no puede exceder 30 caracteres")
    private String ciudad_cliente;
}
