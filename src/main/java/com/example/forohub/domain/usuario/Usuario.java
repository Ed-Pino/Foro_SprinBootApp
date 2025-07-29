package com.example.forohub.domain.usuario;

import jakarta.persistence.*;
import lombok.*; // Asegúrate de tener @Getter y @Setter aquí
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "usuario")
@Getter // <--- Asegúrate de que esta anotación esté aquí
@Setter // <--- Asegúrate de que esta anotación esté aquí
@NoArgsConstructor
@AllArgsConstructor
// @Builder // Si lo estás usando
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "correo_electronico", unique = true)
    private String correoElectronico;

    @Column(name = "contrasena")
    private String contrasena;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_perfil",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "perfil_id"))
    private Set<Perfil> perfiles;


    // Constructor para el registro de nuevos usuarios
    public Usuario(DatosRegistroUsuario datos, String contrasenaHasheada, Set<Perfil> perfiles) {
        this.nombre = datos.nombre();
        this.correoElectronico = datos.correoElectronico();
        this.contrasena = contrasenaHasheada;
        this.perfiles = perfiles;
    }

    // Constructor básico (si lo tienes o necesitas)
    public Usuario(DatosRegistroUsuario datos, String contrasenaHasheada) {
        this.nombre = datos.nombre();
        this.correoElectronico = datos.correoElectronico();
        this.contrasena = contrasenaHasheada;
        // No asigna perfiles aquí
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreoElectronico() { // Ya lo tenías, pero asegúrate de que esté aquí
        return correoElectronico;
    }
    // Métodos de UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return perfiles;
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return correoElectronico;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}