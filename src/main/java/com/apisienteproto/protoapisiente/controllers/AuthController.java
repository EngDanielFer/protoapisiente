package com.apisienteproto.protoapisiente.controllers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apisienteproto.protoapisiente.security.JwtService;
import com.apisienteproto.protoapisiente.services.AuthService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(), request.getPassword()
                    )
            );

            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            String token = jwtService.generarToken(userDetails);

            log.info("Login exitoso para usuario: {}", request.getUsername());

            return ResponseEntity.ok(new LoginResponse(token, userDetails.getUsername()));
        } catch (BadCredentialsException e) {
            log.warn("Credenciales inválidas para: {}", request.getUsername());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("mensaje", "Credenciales inválidas"));
        } catch (DisabledException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(Map.of("mensaje", "Usuario inactivo"));
        }
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registro(@Valid @RequestBody RegistroRequest request) {
        authService.registrar(
                request.getUsername(),
                request.getPassword(),
                request.getNombre()
        );
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("mensaje", "Usuario creado correctamente"));
    }

    @Data
    public static class LoginRequest {

        @NotBlank(message = "El usuario es requerido")
        private String username;

        @NotBlank(message = "La contraseña es requerida")
        private String password;
    }

    @Data
    public static class RegistroRequest {

        @NotBlank(message = "El nombre de usuario es requerido")
        @Size(min = 3, max = 50, message = "El usuario debe tener entre 3 y 50 caracteres")
        private String username;

        @NotBlank(message = "La contraseña es requerida")
        @Size(min = 6, max = 100, message = "La contraseña debe tener entre 6 y 100 caracteres")
        private String password;

        @NotBlank(message = "El nombre es requerido")
        @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
        private String nombre;
    }

    @Data
    public static class LoginResponse {

        private final String token;
        private final String username;
        private final String tipo = "Bearer";
    }

}
