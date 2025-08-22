package com.example.categoriaPelicula.modal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.categoriaPelicula.modal.entity.Elenco;

public interface IElencoDao extends JpaRepository<Elenco, Long>{

}
