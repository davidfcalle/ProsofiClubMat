import { Usuario } from './usuario';
//import {} from '.';


export const ESTADO_ACTIVIDADA = "Activada";
export const ESTADO_DESACTIVADA = "Desactivada";


export class Olimpiada {

  idolimpiada: number;
  nombre: string;
  ciudad: string;
  lugar: string;
  hora: string;
  direccion: string;
  activacion: string;
  fecha: string;
  telefono: string;
  organizador: Usuario;
  //idPrueba : Prueba;

  initializeDeActivated(){
    this.activacion = ESTADO_DESACTIVADA;
  }

}