package com.example.categoriaPelicula.modal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.categoriaPelicula.modal.entity.Pelicula;

public interface IPeliculaDao extends JpaRepository<Pelicula, Long> {

}
