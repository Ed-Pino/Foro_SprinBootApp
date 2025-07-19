package com.example.forohub.domain.usuario;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority; // <-- AÑADIR IMPORT
import org.springframework.security.core.userdetails.UserDetails; // <-- AÑADIR IMPORT

import java.util.Collection; // <-- AÑADIR IMPORT
import java.util.Set;

@Entity
@Table(name = "usuario") // Buena práctica especificar el nombre de la tabla
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
// ----- MODIFICACIÓN CLAVE AQUÍ -----
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "correo_electronico", unique = true) // Buena práctica especificar la columna
    private String correoElectronico;

    @Column(name = "contrasena") // Buena práctica especificar la columna
    private String contrasena;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_perfil",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "perfil_id"))
    private Set<Perfil> perfiles;

    // ----- MÉTODOS REQUERIDOS POR LA INTERFAZ UserDetails -----
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Devolvemos la colección de perfiles/roles del usuario
        return perfiles;
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        // En nuestro sistema, el username es el correo electrónico
        return correoElectronico;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Podemos añadir lógica si las cuentas expiran
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Podemos añadir lógica para bloquear cuentas
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Podemos añadir lógica si las credenciales expiran
    }

    @Override
    public boolean isEnabled() {
        return true; // Podemos añadir lógica para deshabilitar usuarios
    }
}