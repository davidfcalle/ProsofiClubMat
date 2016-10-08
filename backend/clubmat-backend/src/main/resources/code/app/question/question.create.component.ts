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

  ngOnInit(): void {
    this.question = new Pregunta();
  }

  onSubmit(): void {
    alert("Se creó el elemento");
  }
}