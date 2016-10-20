
export class CreateTestDTO {

  fecha: string;
  numpreguntas: number;
  grado: number;
  dificultad: string;
  tema: string;
  prueba: boolean; // Atributo que determina si se debe relacionar la prueba con el usuario.
  idOlimpiada: number; // Atributo que relaciona la prueba con una olimpiada.
  tipo: string;

  constructor(){
    this.idOlimpiada = null;
    this.prueba = true;
  }

}
