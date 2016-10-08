export const CLASIFICACION_PREGUNTA: string = "PREGUNTA";
export const CLASIFICACION_OLIMPIADA: string = "OLIMPIADA";

export const DIFICULTAD_FACIL: string = "FACIL";
export const DIFICULTAD_MEDIA: string = "MEDIA";
export const DIFICULTAD_ALTA: string = "ALTA";

export const DIFICULTADES: string[] = [DIFICULTAD_FACIL, DIFICULTAD_MEDIA, DIFICULTAD_ALTA];
export const CLASIFICACIONES: string[] = [CLASIFICACION_OLIMPIADA, CLASIFICACION_PREGUNTA];


export class Pregunta {

  idpregunta: number;
  clasificacion: string;
  nivelacademico: string;
  tematica: string;
  dificultad: string;
  titulo: string;
  enunciado: string;
  aprobado: string;
  resultado: string;
  opcionpreguntaList: OpcionPregunta[];



}

export class OpcionPregunta {

  idopcionpregunta: number;
  opcion: string;
  correcta: boolean;

}
