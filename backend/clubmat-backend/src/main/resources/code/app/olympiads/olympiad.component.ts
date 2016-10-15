import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Olimpiada } from "../models/olympiad";
import { OlympiadService } from "../services/olympiad.service";


@Component ({
    selector: 'olympiads',
    templateUrl: 'app/olympiads/olympiads.component.html',
})
export class OlympiadsComponent implements OnInit {

  olympiads: Olimpiada[];
  selectedOlympiad: Olimpiada;

  constructor(private olympiadService: OlympiadService){}

  ngOnInit(){
    this.updateOlympiadList();
  }

 changeSelectedOlympiad(olympiad: Olimpiada){
   this.selectedOlympiad = olympiad;
 }


  updateOlympiadList(){
    this.olympiadService.getOlympiadList()
      .then(olympiads => {
        this.olympiads = olympiads;
        console.log(JSON.stringify(this.olympiads));
      })
      .catch(err => alert("Error al cargar las olimpiadas"));
  }

}
