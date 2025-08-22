package com.example.categoriaPelicula.modal.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.categoriaPelicula.modal.entity.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Long>{
	 Optional<Usuario> findByCorreo(String correo);
	    boolean existsByCorreo(String correo);
	    boolean existsByNombreUsuario(String nombreUsuario);
}
