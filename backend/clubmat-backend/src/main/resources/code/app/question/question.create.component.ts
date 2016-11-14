import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";

import { OpcionPregunta, Pregunta, DIFICULTADES, CLASIFICACIONES } from '../models/pregunta';

import { QuestionService } from '../services/question.service';

@Component({
  selector: 'question-create',
  templateUrl: 'app/question/question.create.component.html'
})
export class QuestionCreateComponent implements OnInit {
  question: Pregunta;
  diffOptions: string[] = DIFICULTADES;
  classOptions: string[] = CLASIFICACIONES;

  constructor(private questionService: QuestionService){}

  ngOnInit(): void {
    this.question = new Pregunta();
    this.question.initiualizeNotAproved();
    this.question.initailizeEmptyQuestions();
  }

  goBack(){
    window.history.back();
  }

  onSubmit(): void {
    this.questionService.createQuestion(this.question)
      .then(question => {
        alert(`Pregunta ${this.question.titulo} creada correctamente`);
        this.question = new Pregunta();
        this.question.initailizeEmptyQuestions();
        this.question.initiualizeNotAproved();
      }).catch( err => {
        alert("Error al crear la pregunta");
      });
  }
}
