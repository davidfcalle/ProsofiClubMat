import { Component } from "@angular/core";

import { Usuario } from '../models/usuario';
import { UserService } from '../services/user.service';

@Component({
    selector: 'signin',
    template: '<h2> in the making </h2>'
})
export class SigninComponent {
    username: string;
    password: string;

    constructor(private usersService: UserService){}

}