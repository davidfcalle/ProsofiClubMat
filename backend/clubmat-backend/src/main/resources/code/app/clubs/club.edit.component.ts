import { Component, OnInit } from "@angular/core";
import { Router,ActivatedRoute, Params } from "@angular/router";
import { Club } from "../models/club";
import { Institucion } from '../models/institucion';
import { ClubService } from "../services/club.service";
import * as request from "superagent";

@Component({
    selector: 'clubEdit',
    templateUrl: 'app/clubs/club.edit.component.html',
    styleUrls: ['app/institution/institution.component.css']
})
export class ClubEditComponent implements OnInit{

    club: Club;

    constructor(
        private route: ActivatedRoute,
        private clubService: ClubService,
        private router: Router
    ){ 
        this.club = new Club();
    }

    ngOnInit(){
        var curInstance = this;
        this.route.params.forEach( (params: Params ) =>{
          let id = +params['id'];
          request
            .get(`/api/club/${id}`)
            .end(function(err, res){
              if(err){
                alert("Error al obtener las instituciones");
                return;
              }
              var selected = res.body as Club;
              console.log("se va a editar" + JSON.stringify(selected))
              curInstance.club = selected;
            }); 
          }
        )
    }

    onSubmit(){
        this.clubService.updateClub(this.club)
            .then(res => this.router.navigate(["/clubes"]),
                err => alert('Error en la edición'));
    }
}