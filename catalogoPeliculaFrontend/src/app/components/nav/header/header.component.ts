import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent implements OnInit {
usuario: any = null;

  constructor(private router: Router) {}

  ngOnInit(): void {
    // Obtener información del usuario desde localStorage
    const usuarioStr = localStorage.getItem('usuario');
    this.usuario = usuarioStr ? JSON.parse(usuarioStr) : null;
    
    // No redirigir automáticamente al login desde el navbar
    // La redirección debe manejarse con el AuthGuard
  }

  logout(): void {
    localStorage.removeItem('token');
    localStorage.removeItem('rol');
    localStorage.removeItem('usuario');
    this.usuario = null;
    this.router.navigate(['/login']);
  }


}
