import {Pregunta} from './pregunta'

export class Test {
  idprueba: number;
  fecha: string;
  tema: string;
  numpreguntas: number;
  numcorrectas: number;
  tipoprueba: string;
  enunciado: string;
  idusuario: number;
  preguntaList: Pregunta[];
  nivelacademico:string; //No existe anteriormente el curso asi que el filtro queda incompleto
  
}


