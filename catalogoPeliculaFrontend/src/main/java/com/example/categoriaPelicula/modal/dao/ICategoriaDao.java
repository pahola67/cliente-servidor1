package com.example.categoriaPelicula.modal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.categoriaPelicula.modal.entity.Categoria;

public interface ICategoriaDao extends JpaRepository<Categoria, Long>{


}
