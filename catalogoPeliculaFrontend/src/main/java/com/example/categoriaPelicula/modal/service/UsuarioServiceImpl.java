package com.example.categoriaPelicula.modal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.categoriaPelicula.modal.dao.IUsuarioDao;
import com.example.categoriaPelicula.modal.entity.Usuario;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioServiceImpl  implements IUsuarioService{

	@Autowired
	private IUsuarioDao usuarioDao;
	
	public Usuario registrarUsuario(Usuario usuario) {
        // Aquí puedes validar si el correo ya existe
        if (usuarioDao.existsByCorreo(usuario.getCorreo())) {
            throw new RuntimeException("El correo ya está registrado");
        }
        return usuarioDao.save(usuario);
    }
	
	@Override
	public Usuario crearUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		if (usuarioDao.existsByCorreo(usuario.getCorreo())) {
            throw new RuntimeException("El correo electrónico ya está registrado");
        }
        
        // Validar que el nombre de usuario no exista
        if (usuarioDao.existsByNombreUsuario(usuario.getNombreUsuario())) {
            throw new RuntimeException("El nombre de usuario ya está en uso");
        }
        
        return usuarioDao.save(usuario);
	}

	@Override
	public Usuario obtenerUsuarioPorId(Long id) {
		// TODO Auto-generated method stub
		return usuarioDao.findById(id).orElse(null);

	}

	@Override
	public List<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		return usuarioDao.findAll();
	}

	@Override
	public Usuario actualizarUsuario(Long id, Usuario usuario) {
		// TODO Auto-generated method stub
		Usuario usuarioExistente = obtenerUsuarioPorId(id);
        usuarioExistente.setNombreUsuario(usuario.getNombreUsuario());
        usuarioExistente.setCorreo(usuario.getCorreo());
        // Puedes agregar más campos para actualizar según sea necesario
        return usuarioDao.save(usuarioExistente);
    }

	@Override
	public void eliminarUsuario(Long id) {
		// TODO Auto-generated method stub
		Usuario usuario = obtenerUsuarioPorId(id);
		usuarioDao.delete(usuario);
	}

	@Override
	public Usuario login(String correo, String contrasena) {
		// TODO Auto-generated method stub
Optional<Usuario> usuarioOptional = usuarioDao.findByCorreo(correo);
        
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            // En una aplicación real, deberías comparar contraseñas encriptadas
            if (usuario.getContrasena().equals(contrasena)) {
                usuario.setUltimoAcceso(java.time.LocalDateTime.now());
                usuarioDao.save(usuario);
                return usuario;
            } else {
                throw new RuntimeException("Contraseña incorrecta");
            }
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }

}
