import { Component } from "@angular/core";

import { Usuario } from '../models/usuario';
import { UserService } from '../services/user.service';

@Component({
    selector: 'signin',
    templateUrl: "app/signin/signin.component.html"
})
export class SigninComponent {
    
    username: string;
    password: string;

    constructor(private usersService: UserService){

    }

}