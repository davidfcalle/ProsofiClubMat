import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Usuario } from "../models/usuario";
import { UserService } from "../services/user.service";

@Component({
    selector: 'userList',
    templateUrl: 'app/users/users.component.html',
    styleUrls: ['app/users/users.component.css']
})
export class UserListComponent implements OnInit {

    users: Usuario[];
    selectedUser: Usuario;

    constructor (private router: Router, private userService: UserService){ }

    changeSelected(user: Usuario){
      this.selectedUser = user;
    }

    ngOnInit(): void {
      this.updateUserList();
    }

    updateUserList(){
      this.userService.getUserList()
          .then(users => this.users = users)
          .catch(reason =>{
            alert("Error al cargar la lista de usuario")
          });
    }

    editUser(){
      if(this.selectedUser != null){
        this.router.navigate([`/usuarios/${this.selectedUser.idusuario}/editar`]);
      }else{
        alert("Por favor seleccione el usuario a editar")
      }
    }

    deleteUser(){
      if(this.selectedUser == null){
        alert("Debe seleccionar un usuario a eliminar");
        return;
      }
      this.userService.deleteUser(this.selectedUser)
        .then( deleted =>{
          alert("Usuario Borrado existosamente");
          this.updateUserList();
        }).catch( err => {
          alert("Error al eliminar el usuario. Inténtelo de nuevo más tarde.")
        })
    }

    goBack(){
        window.history.back();
    }
}