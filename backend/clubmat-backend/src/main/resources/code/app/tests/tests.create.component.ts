import { Component, OnInit } from "@angular/core";
import { Router, ActivatedRoute, Params } from "@angular/router";

import { Test } from "../models/test";
import { DIFICULTADES } from "../models/pregunta";

import { CreateTestDTO } from '../dto/CreateTestDTO';

import { QuestionService } from '../services/question.service';
import { TestService } from '../services/test.service';



@Component({
    selector: 'test-create',
    templateUrl: 'app/tests/tests.create.component.html',
})
export class TestCreateComponent implements OnInit {

    dificultades : string[] = DIFICULTADES
    
    prueba : CreateTestDTO;
    
    tipo : string;

    temas: string[];

    idPrueba: number;

    constructor (private route :ActivatedRoute, private router :Router
                    , private questionService: QuestionService, private testService: TestService){
        this.prueba = new CreateTestDTO();
     }


    ngOnInit(){

        this.route.params.forEach( (params: Params ) => {
          let t  = params['tipo'];
          if(t == "examen"){
              this.prueba.prueba = false;
          }else if(t == "ensayo"){
              this.prueba.prueba = true;
          }
        });

        this.questionService.getQuestionTypes()
            .then(types => this.temas = types)
            .catch(err => alert("Error al cargar la lista de temas"));

    }

    onSubmit(): void {
        this.testService.createTest(this.prueba)
            .then(test => {
                this.idPrueba = test.idprueba
                //TODO: Navegar hacia la toma de la prueba
            })
            .catch(err => alert("No se puede crear una pruaba con los parametros establecidos. Revise la cantidad de preguntas disponibles para ese grado, dificultad y tema."));
    }

    goBack(){
        window.history.back();
    }
}
