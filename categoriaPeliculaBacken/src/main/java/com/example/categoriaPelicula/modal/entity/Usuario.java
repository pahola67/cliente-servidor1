package com.example.categoriaPelicula.modal.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column( length = 50)
    private String nombreUsuario;

    @Column
    private String correo;

    private String contrasena;

    @Enumerated(EnumType.STRING)
    private Rol rol = Rol.USUARIO;

    private Boolean activo = true;

    @Column
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Column
    private LocalDateTime ultimoAcceso;

    public enum Rol { USUARIO, ADMIN }
    
    public Usuario() {
    }

    public Usuario(String nombre, String correo, String contrasena) {
        this.nombreUsuario = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getUltimoAcceso() {
		return ultimoAcceso;
	}

	public void setUltimoAcceso(LocalDateTime ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}
    
    

}
