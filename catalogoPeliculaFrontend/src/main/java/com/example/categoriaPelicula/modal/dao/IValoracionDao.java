package com.example.categoriaPelicula.modal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.categoriaPelicula.modal.entity.Valoracion;

public interface IValoracionDao extends JpaRepository<Valoracion, Long>{

}
