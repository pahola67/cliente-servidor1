package com.example.categoriaPelicula.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.categoriaPelicula.modal.entity.Usuario;
import com.example.categoriaPelicula.modal.service.IUsuarioService;

@RestController
@RequestMapping("/auth")
public class authcontroller {
	
	  @Autowired
	    private IUsuarioService usuarioService;

	   /* @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
	        try {
	            Usuario usuario = usuarioService.login(loginRequest.getCorreo(), loginRequest.getContrasena());
	            
	            // En una aplicación real, generarías un token JWT aquí
	            Map<String, Object> response = new HashMap<>();
	            response.put("message", "Login exitoso");
	            response.put("usuario", usuario);
	            response.put("token", "jwt-token-generado-aqui");
	            
	            return ResponseEntity.ok(response);
	        } catch (RuntimeException e) {
	            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
	        }
	    }

	    // Clase interna para la solicitud de login
	    public static class LoginRequest {
	        private String correo;
	        private String contrasena;

	        // Getters y setters
	        public String getCorreo() {
	            return correo;
	        }

	        public void setCorreo(String correo) {
	            this.correo = correo;
	        }

	        public String getContrasena() {
	            return contrasena;
	        }

	        public void setContrasena(String contrasena) {
	            this.contrasena = contrasena;
	        }
	    }*/
	  
	  @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
	        try {
	            Usuario usuario = usuarioService.login(loginRequest.getCorreo(), loginRequest.getContrasena());
	            
	            Map<String, Object> response = new HashMap<>();
	            response.put("message", "Login exitoso");
	            response.put("usuario", usuario);
	            response.put("token", "jwt-token-generado"); // En producción, genera un JWT real
	            
	            return ResponseEntity.ok(response);
	        } catch (RuntimeException e) {
	            Map<String, String> errorResponse = new HashMap<>();
	            errorResponse.put("message", e.getMessage());
	            return ResponseEntity.status(401).body(errorResponse);
	        }
	    }

	    @PostMapping("/registro")
	    public ResponseEntity<?> registrar(@RequestBody Usuario usuario) {
	        try {
	            // Por defecto, todos los nuevos usuarios son USUARIO
	            usuario.setRol(Usuario.Rol.USUARIO);
	            Usuario usuarioGuardado = usuarioService.crearUsuario(usuario);
	            
	            Map<String, Object> response = new HashMap<>();
	            response.put("message", "Usuario registrado exitosamente");
	            response.put("usuario", usuarioGuardado);
	            
	            return ResponseEntity.ok(response);
	        } catch (RuntimeException e) {
	            Map<String, String> errorResponse = new HashMap<>();
	            errorResponse.put("message", e.getMessage());
	            return ResponseEntity.badRequest().body(errorResponse);
	        }
	    }

	    public static class LoginRequest {
	        private String correo;
	        private String contrasena;

	        // Getters y setters
	        public String getCorreo() { return correo; }
	        public void setCorreo(String correo) { this.correo = correo; }
	        public String getContrasena() { return contrasena; }
	        public void setContrasena(String contrasena) { this.contrasena = contrasena; }
	    }

}
