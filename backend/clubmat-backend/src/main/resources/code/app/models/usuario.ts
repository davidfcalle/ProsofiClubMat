export const ROL_ESTUDIANTE = "Estudiante";
export const ROL_ADMINISTRADOR = "Administrador";
export const ROL_PROFESOR = "Profesor";

export const ROLES: string[] = [ ROL_ESTUDIANTE, ROL_ADMINISTRADOR, ROL_PROFESOR ];


export class Usuario {

  idusuario: number;
  nombre: string;
  apellido: string;
  ciudad: string;
  rol: string;
  telefono: number;
  puntaje: number;
  usuario: string;
  email: string;
  contrasena: string;

}
