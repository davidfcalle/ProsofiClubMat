import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";

import { OpcionPregunta, Pregunta } from '../models/pregunta';

import { QuestionService } from '../services/question.service';

@Component({
  selector: 'questionList',
  templateUrl: 'app/question/questions.component.html'
})
export class QuestionsComponent implements OnInit {
  
  questions: Pregunta[];
  selected: Pregunta;

  constructor(private router: Router, private questionService: QuestionService){}

  ngOnInit(): void {
    this.updateQuestionList();
  }

  updateQuestionList(){
    this.questionService.getQuestionList()
      .then((questions) => this.questions = questions)
      .catch((err) => alert("Error al cargar las preguntas"));
  }

  goBack(){
    window.history.back();
  }

}
