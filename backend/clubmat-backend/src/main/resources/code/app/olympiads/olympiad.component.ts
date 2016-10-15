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

 suscribe(){

   if(this.selectedOlympiad == null){
     alert("Por favor seleccione una olimpada");
     return;
   }

   this.olympiadService
    .suscribeToOlympiad(this.selectedOlympiad)
    .then(olympiad => {
      alert(`Te has suscrito a la olimpiada ${olympiad.nombre}`)
    })
    .catch(err =>{
      alert("Error al suscribirse a una olimpiada");
    });
 }

 unsuscribe(){
   if(this.selectedOlympiad == null){
     alert("Por favor seleccione una olimpada");
     return;
   }

   this.olympiadService
    .unSuscribeToOlympiad(this.selectedOlympiad)
    .then(olympiad => {
      alert(`Has dejado de estar inscrito a la olimpiada ${olympiad.nombre}`)
    })
    .catch(err =>{
      alert("Error al suscribirse a una olimpiada");
    });
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
