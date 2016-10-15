import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";

import { Olimpiada } from '../models/olympiad';

import { OlympiadService } from '../services/olympiad.service';

@Component({
  selector: 'olympiad-edit',
  templateUrl: 'app/olympiads/olympiad.edit.component.html'
})
export class OlympiadCreateComponent {

  olympiad: Olimpiada;

  constructor(private olympiadService: OlympiadService){
    this.olympiad = new Olimpiada();
  }

  onSubmit(){
    this.olympiadService.createOlympiad(this.olympiad)
      .then(olympiad => {
        this.olympiad = olympiad; 
        alert(`Olimpiada ${this.olympiad.nombre} creada correctamente`);
        console.log(JSON.stringify(this.olympiad));
      })
      .catch(err=>alert("Error al crear la olimpiada"));
  }
  /**
   * metodo que permite volver hacia atrás
   */
  goBack(){
    window.history.back();
  }

}