import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Usuario } from '../models/usuario';
import { UserService } from '../services/user.service';


@Component({
    selector: 'signup',
    templateUrl: 'app/signup/signup.component.html',
    styleUrls: ['app/signup/signup.component.css']
})
export class SignupComponent implements OnInit {

    user: Usuario;

    constructor(private userService: UserService) {
    }

    ngOnInit(): void {
        this.user =  new Usuario();
    }

    signup(): void{
        console.log("Se crea el usuario...")
        this.userService.createUser(this.user)
            .then(this.showSuccessMessage)
            .catch(this.showErrorMessage);
    }

    showErrorMessage(err: any): void {
        alert(`Error al crear el usuario ${this.user.usuario}. Por favor utilice otro nombre de usuario`);
        this.user = new Usuario();
    }

    showSuccessMessage(user: Usuario): void {
         alert(`Usuario ${user.usuario} creado correctamente.`);     
    }
}