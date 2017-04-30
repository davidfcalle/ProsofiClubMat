import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Olimpiada } from "../models/olympiad";
import { Usuario } from "../models/usuario";
import { OlympiadService } from "../services/olympiad.service";
import { TestService } from "../services/test.service";


@Component ({
    selector: 'olympiads',
    templateUrl: 'app/olympiads/olympiads.component.html',
})
export class OlympiadsComponent implements OnInit {

  olympiads: Olimpiada[];
  selectedOlympiad: Olimpiada;
  users: Usuario[];

  constructor(private olympiadService: OlympiadService, 
    private router: Router,
    private testService: TestService){}

  ngOnInit(){
    this.updateOlympiadList();
  }

 changeSelectedOlympiad(olympiad: Olimpiada){
   this.selectedOlympiad = olympiad;
 }

 viewDetail(){
    if(this.selectedOlympiad != null){
      this.router.navigate([`/olimpiadas/${this.selectedOlympiad.idolimpiada}/detalle`]);
    }else{
      alert("Por favor seleccione la olimpiada a ver")
    }
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
      alert("Error al suscribirse a una olimpiada, es posible que ya estés inscrito");
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


  editCurrentOlympiad(){
    if(this.selectedOlympiad == null){
      alert("se debe seleccionar una olimpiada");
      return;
    }
    this.router.navigate([`/olimpiadas/${this.selectedOlympiad.idolimpiada}/editar`])
  }

  startOlympiad(){
    if(this.selectedOlympiad == null){
     alert("Por favor seleccione una olimpada");
     return;
    }

    if(this.selectedOlympiad.activacion == "Desactivada"){
      alert("Olimpiada aún no está activa");
      return;
    }
    let response:Object;
    this.olympiadService.isSuscribe(this.selectedOlympiad.idolimpiada)
        .then(res => {
          res = JSON.parse(res);
          if(res.value){
            // check if user already has taken the test
            this.testService.hasTaken(this.selectedOlympiad.idprueba.idprueba)
              .then(resp => {
                resp = JSON.parse(resp);
                if(resp.value){
                  alert("Usted ya tomó la prueba.");
                }else{
                  this.router.navigate(['/pruebas/'+this.selectedOlympiad.idprueba.idprueba+'/tomar']);
                }
              }, error => alert("Error"));
          }else{
            alert("Debe inscribirse a la olimpiada antes de poder iniciarla.");
          }
        }, error => alert("Error"));
  }

  viewResults(){
    if(this.selectedOlympiad == null){
     alert("Por favor seleccione una olimpada");
     return;
    }

    if(this.selectedOlympiad.activacion == "Desactivada"){
      alert("Olimpiada aún no está activa");
      return;
    }

    this.router.navigate([`/olimpiadas/${this.selectedOlympiad.idolimpiada}/resultados`]);
  }

}
