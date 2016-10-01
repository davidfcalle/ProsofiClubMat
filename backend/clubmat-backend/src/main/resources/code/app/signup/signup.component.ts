import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Usuario } from '../models/usuario';
import * as request from "superagent";

@Component({
    selector: 'signup',
    templateUrl: 'app/signup/signup.component.html',
    styleUrls: ['app/signup/signup.component.css']
})
export class SignupComponent implements OnInit {

    user: Usuario;

    constructor() {
    }

    ngOnInit(): void {
        this.user =  new Usuario();
    }

    signup(): void{
        var curInstance = this;
        console.log("Se crea el usuario...")

        request
          .post(`/api/usuario`)
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

    showErrorMessage(err: any): void {
        alert(`Error al crear el usuario ${this.user.usuario}. Por favor utilice otro nombre de usuario`);
        this.user = new Usuario();
    }

    showSuccessMessage(user: Usuario): void {
         alert(`Usuario ${user.usuario} creado correctamente.`);
         this.user = new Usuario();  
    }
}