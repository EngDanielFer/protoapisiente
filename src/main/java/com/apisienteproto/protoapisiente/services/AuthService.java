package com.apisienteproto.protoapisiente.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apisienteproto.protoapisiente.exceptions.RecursoYaExisteException;
import com.apisienteproto.protoapisiente.models.UsuarioModel;
import com.apisienteproto.protoapisiente.repositories.IUsuarioRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final IUsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UsuarioModel registrar(String username, String password, String nombre) {
        if (usuarioRepository.existsByUsername(username)) {
            throw new RecursoYaExisteException(
                    "El nombre de usuario '" + username + "' ya está en uso"
            );
        }

        UsuarioModel nuevoUsuario = UsuarioModel.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .nombre(nombre)
                .rol("ADMIN")
                .activo(true)
                .build();

        UsuarioModel guardado = usuarioRepository.save(nuevoUsuario);
        log.info("Nuevo usuario registrado: {}", username);
        return guardado;
    }
}