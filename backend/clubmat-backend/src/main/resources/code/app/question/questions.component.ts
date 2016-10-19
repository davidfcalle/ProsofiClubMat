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

  changeSelected(question :Pregunta){
    this.selected = question;
  }

  edit(){
    if(this.selected == null){
      alert("Por favor seleccione una pregunta a editar");
      return;
    }
    this.router.navigate([`/preguntas/${this.selected.idpregunta}/editar`])
  }

  deleteQuestion(){
    if(this.selected == null){
      alert("Por favor seleccione una pregunta a eliminar");
      return;
    }
    var shouldDelete: boolean = confirm("¿Está seguro que desea borrar la pregunta?");
    if(!shouldDelete){ return; }
    this.questionService.deleteQuestion(this.selected)
      .then(result =>{
        alert("La pregunta fue borrada exitosamente");
        this.selected = null;
        this.updateQuestionList();
      })
      .catch(err =>{
        alert("Ocurrió un error al intentar eliminar la pregunta");
      });
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
