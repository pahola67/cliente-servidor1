package com.example.categoriaPelicula.modal.entity;

import jakarta.persistence.*;

@Entity 
@Table(name="favoritos")
public class Favorito {
	
	private static final long serialVersionUID = 1;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Pelicula pelicula;

    private String fechaAgregado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public String getFechaAgregado() {
		return fechaAgregado;
	}

	public void setFechaAgregado(String fechaAgregado) {
		this.fechaAgregado = fechaAgregado;
	}
    
    

}
