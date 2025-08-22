package com.example.categoriaPelicula.modal.service;

import java.util.List;

import com.example.categoriaPelicula.modal.entity.Categoria;

public interface ICategoriaService {

	 Categoria crearCategoria(Categoria categoria);
	    Categoria obtenerCategoriaPorId(Long id);
	    List<Categoria> listarCategorias();
	    Categoria actualizarCategoria(Long id, Categoria categoria);
	    void eliminarCategoria(Long id);
}
