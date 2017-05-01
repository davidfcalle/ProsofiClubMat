import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";

import { ClubDTO } from '../dto/clubDTO';
import { Usuario, ROLES } from '../models/usuario';
import { ClubService } from '../services/club.service';

import * as request from "superagent";

@Component({
    selector: 'signup',
    templateUrl: 'app/signup/signup.component.html',
    styleUrls: ['app/signup/signup.component.css']
})
export class SignupComponent implements OnInit {

    
    roles = ROLES;
    clubs: ClubDTO[];
    user: Usuario;
    club: ClubDTO;

    constructor(
        private clubService: ClubService
    ) {

    }

    ngOnInit(): void {
        this.user =  new Usuario();
        this.getClubs();
    }

    signup(): void{
        var curInstance = this;
        console.log("Se crea el usuario...")
        if(this.club == null){
            alert('Debe seleccionar un club para el usuario.');
            return;
        }
        request
          .post(`/api/user/create?idclub=${this.club.idclub}`)
          .send(this.user)
          .set('Accept', 'application/json')
          .end(function addUser(err: any, res: request.Response){
            if(err){
              curInstance.showErrorMessage(err);
            }else{
              var user = res.body as Usuario;
              curInstance.showSuccessMessage(user);
            }
          });
    }

    getClubs(): void{
         this.clubService.getClubs()
            .then(res => {
                this.clubs = res;
                /*if(this.clubs.length > 0){
                    this.club = this.clubs[0];
                }*/
            }, error => alert('error'));
     }

    showErrorMessage(err: any): void {
        alert(`Error al crear el usuario ${this.user.usuario}. Por favor utilice otro nombre de usuario`);
        this.user = new Usuario();
    }

    showSuccessMessage(user: Usuario): void {
         alert(`Usuario ${user.usuario} creado correctamente.`);
         this.user = new Usuario();  
    }
}
