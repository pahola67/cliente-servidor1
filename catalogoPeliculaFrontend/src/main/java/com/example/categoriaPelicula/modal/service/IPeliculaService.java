package com.example.categoriaPelicula.modal.service;

import java.util.List;

import com.example.categoriaPelicula.modal.entity.Pelicula;

public interface IPeliculaService {
	
	 Pelicula crearPelicula(Pelicula pelicula);
	    Pelicula obtenerPeliculaPorId(Long id);
	    List<Pelicula> listarPeliculas();
	    Pelicula actualizarPelicula(Long id, Pelicula pelicula);
	    void eliminarPelicula(Long id);

}
