export const CLASIFICACION_PRACTICA: string = "Practica";
export const CLASIFICACION_OLIMPIADA: string = "Olimpiada";

export const DIFICULTAD_FACIL: string = "Fácil";
export const DIFICULTAD_MEDIA: string = "Media";
export const DIFICULTAD_ALTA: string = "Alta";

export const DIFICULTADES: string[] = [DIFICULTAD_FACIL, DIFICULTAD_MEDIA, DIFICULTAD_ALTA];
export const CLASIFICACIONES: string[] = [CLASIFICACION_OLIMPIADA, CLASIFICACION_PRACTICA];


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

  initailizeEmptyQuestions() {
    this.opcionpreguntaList = [
      new OpcionPregunta(),
      new OpcionPregunta(),
      new OpcionPregunta(),
      new OpcionPregunta()
    ];
    this.opcionpreguntaList[0].correcta = true;
    this.opcionpreguntaList[1].correcta = false;
    this.opcionpreguntaList[2].correcta = false;
    this.opcionpreguntaList[3].correcta = false;
  }

}

export class OpcionPregunta {

  idopcionpregunta: number;
  opcion: string;
  correcta: boolean;

}
