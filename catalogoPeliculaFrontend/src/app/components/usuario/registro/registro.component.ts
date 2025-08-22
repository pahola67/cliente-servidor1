import { Component } from '@angular/core';
import { UsuarioService } from '../../../Service/usuario.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrl: './registro.component.css'
})
export class RegistroComponent {
  nombre = '';
  correo = '';
  contrasena = '';
  mensaje = '';
  isLoading = false;

  constructor(
    private usuarioService: UsuarioService, 
    private router: Router
  ) {}

  registrar() {
    this.isLoading = true;
    this.mensaje = '';
    
    const nuevoUsuario = {
      nombre: this.nombre,
      correo: this.correo,
      contrasena: this.contrasena
    };

    console.log('Intentando registrar usuario:', nuevoUsuario);

    this.usuarioService.registrar(nuevoUsuario).subscribe({
      next: (response) => {
        this.isLoading = false;
        this.mensaje = 'Registro exitoso. Redirigiendo al login...';
        console.log('Respuesta del servidor:', response);
        
        setTimeout(() => {
          this.router.navigate(['/login']);
        }, 2000);
      },
      error: (error) => {
        this.isLoading = false;
        console.error('Error completo en registro:', error);
        
        if (error.status === 0) {
          this.mensaje = 'Error de conexión: Verifica que el backend esté ejecutándose y tenga CORS configurado.';
        } else if (error.status === 404) {
          this.mensaje = 'Error: Endpoint no encontrado. Verifica la URL del servicio.';
        } else {
          this.mensaje = 'Error al registrar: ' + (error.error?.message || error.message || 'Intenta nuevamente');
        }
      }
    });
  }

  goToLogin() {
    this.router.navigate(['/login']);
  }
}
