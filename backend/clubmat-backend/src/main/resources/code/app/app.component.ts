import { Component, OnInit } from '@angular/core';

import { Usuario } from './models/usuario';

import { UserService } from './services/user.service';

@Component({
    selector: 'app',
    template: `
        <nav>
            <div class="nav-wrapper">
                <a href="#!" class="brand-logo">&nbsp;ClubMat 2</a>
                <a  materialize="sideNav" [materializeParams]="[{edge:'left'}]" data-activates="slide-out" class="button-collapse"><i class="material-icons">menu</i></a>
                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li routerLinkActive="active"><a class ="purple darken-2" routerLink="/signup">Crear Usuario</a></li>
                    <li routerLinkActive="active"><a class ="light-blue accent-4" routerLink="/signin">Iniciar Sesión</a></li>
                    <li routerLinkActive="active"><a class ="teal accent-4" routerLink="/instituciones">Instituciones</a></li>
                    <li routerLinkActive="active"><a class ="green accent-4" routerLink="/clubes">Clubes</a></li> 
                    <!-- <li routerLinkActive="active"><a class ="yellow accent-4" routerLink="/pruebas">Pruebas</a></li> -->
                    <li routerLinkActive="active"><a class ="orange accent-4" routerLink="/olimpiadas">Olimpiadas</a></li>
                    <li routerLinkActive="active"><a class ="lime accent-4" routerLink="/usuarios">Usuarios</a></li>
                    <li routerLinkActive="active"><a class ="red accent-4"  routerLink="/preguntas">Preguntas</a></li>
                    <li *ngIf="currentUser != null"><a routerLink="/usuarios/{{currentUser.idusuario}}/editar"><i class="material-icons" style="max-height:100%">account_circle</i></a></li>
                    <li *ngIf="currentUser != null" routerLinkActive="active"><a routerLink="/usuarios/{{currentUser.idusuario}}/editar">{{currentUser.nombre}} - Rol: {{currentUser.rol}}</a></li>
                    <li><a class ="" href="/logout">Cerrar Sesión</a></li>
                </ul>
                <ul id="mobile-demo" class="side-nav" id="slide-out">
                    <li *ngIf="currentUser != null"><a routerLink="/usuarios/{{currentUser.idusuario}}/editar"><i class="material-icons medium center" style="max-height:100%">account_circle</i> {{currentUser.nombre}} - Rol: {{currentUser.rol}}</a></li>
                    <li routerLinkActive="active"><a class ="purple darken-2" routerLink="/signup">Crear Usuario</a></li>
                    <li routerLinkActive="active"><a class ="light-blue accent-4" routerLink="/signin">Iniciar Sesión</a></li>
                    <li routerLinkActive="active"><a class ="teal accent-4" routerLink="/instituciones">Instituciones</a></li>
                    <li routerLinkActive="active"><a class ="green accent-4" routerLink="/clubes">Clubes</a></li>
                    <li routerLinkActive="active"><a class ="lime accent-4" routerLink="/usuarios">Usuarios</a></li>
                    <!-- <li routerLinkActive="active"><a class ="yellow accent-4" routerLink="/pruebas">Pruebas</a></li> -->
                    <li routerLinkActive="active"><a class ="orange accent-4" routerLink="/instituciones">Olimpiadas</a></li>
                    <li routerLinkActive="active"><a class ="red accent-4"  routerLink="/preguntas">Preguntas</a></li>
                    <li><a class ="red accent-4" href="/logout">Cerrar Sesión</a></li>
                </ul>
            </div>
        </nav>
        <router-outlet></router-outlet>
    `
})
export class AppComponent implements OnInit {

  currentUser: Usuario;

  constructor(private userService: UserService){
    this.currentUser = null;
   }
    
  ngOnInit(){
    this.userService.getCurrentUser()
      .then(user=> this.currentUser = user)
      .catch(err => console.log("Aún no ha iniciado sesión"));
  }
}
