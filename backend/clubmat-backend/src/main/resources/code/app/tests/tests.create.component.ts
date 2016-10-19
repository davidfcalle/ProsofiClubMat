import { Component, OnInit } from "@angular/core";
import { Router, ActivatedRoute, Params } from "@angular/router";
import { Test } from "../models/test";
import { DIFICULTADES } from "../models/pregunta";



@Component({
    selector: 'test-create',
    templateUrl: 'app/tests/tests.create.component.html',
})
export class TestCreateComponent implements OnInit {
    dificultades : string[] = DIFICULTADES
    prueba : Test;
    tipo : string;
    constructor (private route :ActivatedRoute, private router :Router){
            this.prueba = new Test();

     }


    ngOnInit(){
        console.log(this.route.params);
        this.route.params.forEach( (params: Params ) =>{
          let t  = params['tipo'];
          this.tipo = t;
        });
    }

    onSubmit(): void {
    /*this.questionService.createQuestion(this.question)
      .then(question => {
        alert(`Pregunta ${this.question.titulo} creada correctamente`);
        this.question = new Pregunta();
        this.question.initailizeEmptyQuestions();
        this.question.initiualizeNotAproved();
      }).catch( err => {
        alert("Error al crear la pregunta");
      });*/
  }

    goBack(){
        window.history.back();
    }
}