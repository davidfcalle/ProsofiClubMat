import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";

import { Olimpiada } from '../models/olympiad';

import { OlympiadService } from '../services/olympiad.service';

@Component({
  selector: 'institution-create',
  templateUrl: 'app/olympiads/olympiad.create.component.html'
})
export class OlympiadCreateComponent {

  olympiad: Olimpiada;
  grade: number;

  constructor(private olympiadService: OlympiadService){
    this.olympiad = new Olimpiada();
    this.olympiad.initializeDeActivated();
  }

  onSubmit(){
    console.log(this.grade);
    this.olympiadService.createOlympiad(this.olympiad,this.grade)
      .then(olympiad => {
        this.olympiad = olympiad; 
        alert(`Olimpiada ${this.olympiad.nombre} creada correctamente`);
        console.log(JSON.stringify(this.olympiad));
      })
      .catch(err=>alert(err));
  }
  /**
   * metodo que permite volver hacia atrás
   */
  goBack(){
    window.history.back();
  }

}