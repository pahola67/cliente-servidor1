import { Component } from '@angular/core';
import { UsuarioService } from '../../../Service/usuario.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

   /* correo = '';
  contrasena = '';
  mensaje = '';
  isLoading = false;

  constructor(
    private usuarioService: UsuarioService, 
    private router: Router
  ) {}

  login() {
    this.isLoading = true;
    this.mensaje = '';

    this.usuarioService.login(this.correo, this.contrasena).subscribe({
      next: (response: any) => {
        this.isLoading = false;
        
        console.log('Respuesta del login:', response);
        
        // Maneja diferentes estructuras de respuesta
        const usuario = response.usuario || response;
        const token = response.token || usuario.token;
        const rol = usuario.rol || response.rol;
        
        // Mensaje de bienvenida
        if (usuario.nombreUsuario) {
          this.mensaje = 'Bienvenido ' + usuario.nombreUsuario;
        } else if (usuario.nombre) {
          this.mensaje = 'Bienvenido ' + usuario.nombre;
        } else {
          this.mensaje = '¡Login exitoso!';
        }

        // Guardar en localStorage
        if (token) localStorage.setItem('token', token);
        if (rol) localStorage.setItem('rol', rol);
        localStorage.setItem('usuario', JSON.stringify(usuario));
        
        // Redirigir al catálogo después de 1 segundo
        setTimeout(() => {
          this.router.navigate(['/catalogo']);
        }, 1000);
      },
      error: (error) => {
        this.isLoading = false;
        console.error('Error en login:', error);
        
        if (error.status === 401) {
          this.mensaje = 'Credenciales inválidas';
        } else if (error.status === 404) {
          this.mensaje = 'Servicio no disponible';
        } else {
          this.mensaje = error.error?.message || 'Error al conectar con el servidor';
        }
      }
    });
  }

  goToRegister() {
    this.router.navigate(['/registro']);
  }*/
  correo = '';
  contrasena = '';
  mensaje = '';
  isLoading = false;
  usuario: any = null;
  usuarioAutenticado = false;

  constructor(
    private usuarioService: UsuarioService, 
    private router: Router
  ) {
    // Verificar si hay un usuario autenticado al cargar el componente
    const usuarioGuardado = localStorage.getItem('usuario');
    if (usuarioGuardado) {
      this.usuario = JSON.parse(usuarioGuardado);
      this.usuarioAutenticado = true;
    }
  }

  login() {
    this.isLoading = true;
    this.mensaje = '';

    this.usuarioService.login(this.correo, this.contrasena).subscribe({
      next: (response: any) => {
        this.isLoading = false;
        
        console.log('Respuesta del login:', response);
        
        // Maneja diferentes estructuras de respuesta
        this.usuario = response.usuario || response;
        const token = response.token || this.usuario.token;
        const rol = this.usuario.rol || response.rol;
        
        // Mensaje de bienvenida
        if (this.usuario.nombreUsuario) {
          this.mensaje = 'Bienvenido ' + this.usuario.nombreUsuario;
        } else if (this.usuario.nombre) {
          this.mensaje = 'Bienvenido ' + this.usuario.nombre;
        } else {
          this.mensaje = '¡Login exitoso!';
        }

        // Guardar en localStorage
        if (token) localStorage.setItem('token', token);
        if (rol) localStorage.setItem('rol', rol);
        localStorage.setItem('usuario', JSON.stringify(this.usuario));
        
        // Actualizar estado de autenticación
        this.usuarioAutenticado = true;
        
        // Redirigir al catálogo después de 1 segundo
        setTimeout(() => {
          this.router.navigate(['/catalogo']);
        }, 1000);
      },
      error: (error) => {
        this.isLoading = false;
        console.error('Error en login:', error);
        
        if (error.status === 401) {
          this.mensaje = 'Credenciales inválidas';
        } else if (error.status === 404) {
          this.mensaje = 'Servicio no disponible';
        } else {
          this.mensaje = error.error?.message || 'Error al conectar con el servidor';
        }
      }
    });
  }

  logout() {
    // Limpiar datos de autenticación
    localStorage.removeItem('token');
    localStorage.removeItem('rol');
    localStorage.removeItem('usuario');
    
    // Actualizar estado
    this.usuario = null;
    this.usuarioAutenticado = false;
    this.mensaje = 'Sesión cerrada correctamente';
    
    // Redirigir a la página principal
    this.router.navigate(['/']);
  }

  goToRegister() {
    this.router.navigate(['/registro']);
  }
}

