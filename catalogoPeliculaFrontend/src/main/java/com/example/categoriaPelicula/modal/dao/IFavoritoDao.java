package com.example.categoriaPelicula.modal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.categoriaPelicula.modal.entity.Favorito;

public interface IFavoritoDao extends JpaRepository<Favorito, Long>{

}
