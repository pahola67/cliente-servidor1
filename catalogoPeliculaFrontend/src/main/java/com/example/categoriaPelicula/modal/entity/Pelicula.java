package com.example.categoriaPelicula.modal.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name="peliculas")
public class Pelicula {
	
	private static final long serialVersionIU = 1L;
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id; // Cambiado de Integer a Long

	    private String titulo;
	    private String director;
	    private Integer anio;
	    private Integer duracion;
	    private String idioma = "Español";
	    private String pais = "Estados Unidos";

	    @Column(name = "creado_por")
	    private String creadoPor;

	    @Column(name = "fecha_creacion")
	    private LocalDateTime fechaCreacion = LocalDateTime.now();

	    @Column(name = "fecha_actualizacion")
	    private LocalDateTime fechaActualizacion = LocalDateTime.now();
    
	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

    
}
