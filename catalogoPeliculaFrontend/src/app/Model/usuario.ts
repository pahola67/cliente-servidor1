export class Usuario {
  id?: number;
  public nombre: string = "";
  correo: string = "";
  contrasena: string = "";
  rol?: 'usuario' | 'admin';
  activo?: boolean;
  fecha_creacion?: Date;
  ultimo_acceso?: Date | null;

}