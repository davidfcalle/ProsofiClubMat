import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Club } from "../models/club";
import { Institucion } from '../models/institucion';
import { ClubService } from "../services/club.service";
import * as request from "superagent";

@Component({
    selector: 'clubCreate',
    templateUrl: 'app/clubs/club.create.component.html',
    styleUrls: ['app/institution/institution.component.css']
})
export class ClubCreateComponent implements OnInit{

    club : Club;
    institutions: Institucion[];
    institution: Institucion;

    constructor(
        private clubService: ClubService,
        private router: Router){
    }

    onSubmit():void{
       this.club.idinstitucion = this.institution;
       if(this.institution == null){
           alert('Debe seleccionar una institución.');
           return;
       }
       this.saveClub();
    }

    saveClub(){
        var currentInstance = this;
        this.clubService.createClub(this.club)
            .then(res => {
                var clb: Club = res as Club;
                alert(`club ${clb.nombreclub} creado exitosamente.`)
                currentInstance.router.navigate(["/clubes"]);
            },err => alert('Error creando el club.'))
    }

    ngOnInit(){
        this.club = new Club();
        this.getInstitutions();
    }

    getInstitutions(): void{
         var call = this;
         request
            .get('/api/institucion?size=99999')
            .end(function(err, res){
                if(err){
                    alert("Error al obtener las instituciones");
                    return;
                }
                var institutionsRes = res.body._embedded.instituciones as Institucion[];
                console.log(institutionsRes);
                call.institutions = institutionsRes;
                /*if(institutionsRes.length > 0){
                    call.institution = institutionsRes[0];
                }*/
            });
     }

}