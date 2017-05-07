import { Component, OnInit } from "@angular/core";
import { Router, ActivatedRoute, Params } from "@angular/router";

import { Test } from "../models/test";
import { Pregunta, OpcionPregunta } from '../models/pregunta';

import { TestService } from '../services/test.service';
import { QuestionService } from '../services/question.service';

@Component({
    selector: 'take-test',
    templateUrl: 'app/tests/take.tests.component.html',
})
export class TakeTestComponent implements OnInit {

  current: Test;
  currentQuestion: Pregunta;
  questionIndex: number;
  correct: number;
  selectedOption: OpcionPregunta;
  inTest: boolean;
  allSelectedOptions: OpcionPregunta[];
  results: any;

  time: number;
  
  constructor (private router: Router, private route: ActivatedRoute, private testService: TestService,
               private questionService: QuestionService) {
    this.questionIndex = 0;
    this.correct = 0;
    this.inTest = true;
    this.allSelectedOptions = [];
  }


  ngOnInit(){
    this.route.params.forEach( (params: Params) => {
      let id = +params['id'];
      console.log("Se obtiene la prueba"+ id)
      this.testService.getTest(id)
        .then(test => {
          this.current = test;
          this.time = new Date().getTime();
          console.log(this.time);
          this.loadCurrentQuestion();
        })
        .catch(err => alert("Error al cargar el examen"));
    });
  }

  changeSelectedOption(option: OpcionPregunta){
    this.selectedOption = option;
  }

  answerQuestion(option: OpcionPregunta){
    if(this.selectedOption == null){
      alert("Debe seleccionar una opción");
      return;
    }
    this.allSelectedOptions.push(option);
    if(this.selectedOption.correcta == true){
      this.correct++;
    }
    this.getNextQuestion();
  }

  getNextQuestion(){
    this.questionIndex = this.questionIndex + 1;
    if(this.questionIndex < this.current.preguntaList.length){
      this.loadCurrentQuestion();
      this.selectedOption = null;
    }else{
      this.questionIndex = this.questionIndex - 1; // para que no se pase del índice de la pregunta
      this.endTest();
    }
  }

  endTest(){
    alert("Felicitaciones Terminaste la prueba");
    this.getTestResults();
    this.current.numcorrectas = this.correct;
    this.time = new Date().getTime() - this.time;
    this.testService.updateTest(this.current,this.time)
      .then(test => console.log("Prueba Creada Exitosamente"))
      .catch(err => alert("Error al guardar los resultados de la prueba"))
    this.inTest = false;
  }

  loadCurrentQuestion(){
    this.questionService
      .getQuestion(this.current.preguntaList[this.questionIndex].idpregunta)
      .then(question =>{
        this.currentQuestion = question;
        this.currentQuestion.opcionpreguntaList = this.shuffleArray(this.currentQuestion.opcionpreguntaList);
      })
      .catch(err => alert("Error al cargar la pregunta inténtelo de nuevo"));
  }

  /**
 * Randomize array element order in-place.
 * Using Durstenfeld shuffle algorithm.
 */
shuffleArray(array: any) {
    for (var i = array.length - 1; i > 0; i--) {
        var j = Math.floor(Math.random() * (i + 1));
        var temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    return array;
}

  getTestResults(){
    var res: any[] = [];
    for(var i = 0; i < this.allSelectedOptions.length; i++){
      res.push({pregunta: this.current.preguntaList[i], opcion: this.allSelectedOptions[i]});
    }
    this.results = res;
    console.log(this.results);
  }



  goBack(){
      window.history.back();
  }
}
