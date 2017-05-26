import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { ClubDTO } from "../dto/clubDTO";
import { Institucion } from '../models/institucion';
import { ClubService } from "../services/club.service";
import * as request from "superagent";

@Component({
    selector: 'clubList',
    templateUrl: 'app/clubs/club.component.html',
    styleUrls: ['app/institution/institution.component.css']
})
export class ClubListComponent implements OnInit {

    clubs: ClubDTO[];
    selectedClub: ClubDTO;

    constructor (private router: Router,
        private clubService: ClubService){

     }

     changeSelectedIntitution(club: ClubDTO): void{
         this.selectedClub = club;
     }

    ngOnInit(): void {
         this.clubService.getClubs()
            .then(res => this.clubs = res, error => alert('error'));
    }

     editCurrentClub(){
         if(this.selectedClub == null){
             alert('Debe seleccionar un club para editar.');
             return;
         }
         this.router.navigate([`/clubes/${this.selectedClub.idclub}/editar`]);
     }

     deleteClub(){

     }

     goBack(){
         window.history.back();
     }
}