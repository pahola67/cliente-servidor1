package com.example.categoriaPelicula.modal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.categoriaPelicula.modal.dao.ICategoriaDao;
import com.example.categoriaPelicula.modal.entity.Categoria;

@Service
public class CategoriaServiceImpl implements ICategoriaService{

	private ICategoriaDao categoriaDao;
	
	@Override
	public Categoria crearCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return categoriaDao.save(categoria);
	}

	@Override
	public Categoria obtenerCategoriaPorId(Long id) {
		// TODO Auto-generated method stub
		return categoriaDao.findById(id).orElse(null);
	}

	@Override
	public List<Categoria> listarCategorias() {
		// TODO Auto-generated method stub
		return categoriaDao.findAll();
	}

	@Override
	public Categoria actualizarCategoria(Long id, Categoria categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarCategoria(Long id) {
		// TODO Auto-generated method stub
        categoriaDao.deleteById(id);
	}

}
