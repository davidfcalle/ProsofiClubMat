import { Component, OnInit } from "@angular/core";
import { Router, ActivatedRoute, Params } from "@angular/router";
import { Usuario } from '../models/usuario';
import { UserService } from '../services/user.service';

@Component({
    selector: 'user-edit',
    templateUrl: 'app/users/user.edit.component.html',
    styleUrls: ['app/users/user.edit.component.css']
})
export class UserEditComponent implements OnInit {

    user: Usuario;

    constructor(private userService: UserService, private route: ActivatedRoute, private router:Router) {
        var curInstance = this;
        this.route.params.forEach( (params: Params) =>{
          let id = +params['id'];
          userService.getUser(id)
            .then(user => curInstance.user = user)
            .catch(err => alert("Error al obtener el usuario."));
        });
    }

    ngOnInit(): void {
        this.user =  new Usuario();
    }

    save(){
        this.userService.updateUser(this.user)
          .then(user => alert("Usuario actualizado correctamente"))
          .catch(err => alert("Error al actualizar el usuario inténtelo de nuevo"))
    }
}