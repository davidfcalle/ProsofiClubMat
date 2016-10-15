import { Component, OnInit } from "@angular/core";
import { Router, ActivatedRoute, Params } from "@angular/router";

import { Olimpiada, ESTADO_ACTIVIDADA } from '../models/olympiad';
import { Usuario } from '../models/usuario';

import { OlympiadService } from '../services/olympiad.service';

@Component({
  selector: 'olympiad-detail',
  templateUrl: 'app/olympiads/olympiad.detail.component.html'
})
export class OlympiadDetailComponent implements OnInit {

  olympiad: Olimpiada;
  users: Usuario[];

  constructor(private olympiadService: OlympiadService,
    private route: ActivatedRoute, private router:Router){
    this.olympiad = new Olimpiada();
  }


  ngOnInit(){
    this.route.params.forEach( (params: Params ) =>{
      let id = +params['id'];
      this.olympiadService.getOlympiad(id)
        .then(olympiad => this.olympiad = olympiad)
        .catch(err => alert("Error al cargar la olimpiada"));

      this.olympiadService.getUserList(id)
        .then(users => this.users = users)
        .catch(err => alert("Error al cargar la lista de usuarios"));
    });
  }

  onSubmit(){
    this.olympiad.activacion = ESTADO_ACTIVIDADA;

    this.olympiadService.updateOlympiad(this.olympiad)
      .then(olympiad => {
        this.olympiad = olympiad;
        alert("olimpiada activada correctamente")
      }).catch(err => {
        alert("Error al activar la olimpiada")
      })
  }

  goBack(){
    window.history.back();
  }

}