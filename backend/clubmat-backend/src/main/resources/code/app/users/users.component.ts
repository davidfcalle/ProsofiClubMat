import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Usuario } from "../models/usuario";
import { UserService } from "../services/user.service";
import * as request from "superagent";

@Component({
    selector: 'userList',
    templateUrl: 'app/users/users.component.html',
    styleUrls: ['app/users/users.component.css']
})
export class UserListComponent implements OnInit {

    users: Usuario[];
    selectedUser: Usuario;

    constructor (private router: Router, private userService: UserService){

    }

    changeSelected(user: Usuario){
      this.selectedUser = user;
    }

    ngOnInit(): void {
      this.userService.getUserList()
          .then(users => this.users = users)
          .catch(reason =>{
            alert("Error al cargar la lista de usuario")
          });
    }
}