package com.example.categoriaPelicula.modal.service;

import java.util.List;

import com.example.categoriaPelicula.modal.entity.Usuario;

public interface IUsuarioService {

	 Usuario crearUsuario(Usuario usuario);
	    Usuario obtenerUsuarioPorId(Long id);
	    List<Usuario> listarUsuarios();
	    Usuario actualizarUsuario(Long id, Usuario usuario);
	    void eliminarUsuario(Long id);
	    Usuario login(String correo, String contrasena);

}
