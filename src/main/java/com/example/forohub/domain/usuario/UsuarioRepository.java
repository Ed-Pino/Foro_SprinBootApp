package com.example.forohub.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // este metodo es usado por AutenticacionService
    Optional<Usuario> findByCorreoElectronico(String correoElectronico);


}