import { Component, OnInit } from "@angular/core";
import { Router, ActivatedRoute, Params } from "@angular/router";
import { Pregunta, OpcionPregunta, DIFICULTADES, CLASIFICACIONES, APROVADOS } from "../models/pregunta";
import { QuestionService } from "../services/question.service";

@Component({
    selector: 'questionEdit',
    templateUrl: 'app/question/question.edit.component.html',
})
export class QuestionEditComponent implements OnInit {
     
     diffOptions: string[] = DIFICULTADES;
     classOptions: string[] = CLASIFICACIONES;
     aprovedOptions: string[] = APROVADOS;

     question : Pregunta;

     constructor (private questionService: QuestionService, private route :ActivatedRoute, private router :Router){
         this.question = new Pregunta();
     }
 
    ngOnInit(): void {
        this.question = new Pregunta();
        this.question.initailizeEmptyQuestions();
        var curInstance = this;
        this.route.params.forEach( (params: Params ) =>{
          let id = +params['id'];
          this.questionService.getQuestion(id)
            .then(question => this.question = question)
            .catch(err => alert("Error al obtener la pregunta"));
        });
    }


    onSubmit():void{
       this.saveQuestion();
    }

    saveQuestion(): void {
        this.questionService.createQuestion(this.question)
            .then(question =>{
                alert("Pregunta editada correctamente");
            })
            .catch(err => alert("Error al editar la pregunta"));
    }


    goBack(){
        window.history.back();
    }
}