import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Club } from "../models/club";
import { InstitutionService } from "../services/institution.service";
import * as request from "superagent";

@Component({
    selector: 'clubList',
    templateUrl: 'app/institution/institution.component.html',
    styleUrls: ['app/institution/institution.component.css']
})
export class ClubListComponent implements OnInit {

    clubs: Club[];

    ngOnInit(): void {
         //this.getInstitutions(); 
    }

    getInstitutions(): void{
         var call = this;
         request
            .get('/api/club?size=99999')
            .end(function(err, res){
                if(err){
                    alert("Error al obtener las instituciones");
                    return;
                }
                var institutionsRes = res.body._embedded.instituciones as Club[]
                console.log(institutionsRes);
                call.clubs = institutionsRes;
            });
     }
}