import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../Model/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

   public apiUrl = 'http://localhost:8080/usuarios'; // Añadí /api para ser más estándar

  constructor(private http: HttpClient) { }

  registrar(usuario: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/registro`, usuario);
  }

  login(correo: string, contrasena: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/login`, { correo, contrasena });
  }

  obtenerUsuarios(): Observable<Usuario[]> {
    // Añade el token en los headers si es necesario
    return this.http.get<Usuario[]>(this.apiUrl);
  }
}
