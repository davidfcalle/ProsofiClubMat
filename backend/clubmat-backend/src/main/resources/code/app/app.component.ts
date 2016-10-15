import { Component } from '@angular/core';

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
                    <li routerLinkActive="active"><a class ="green accent-4" routerLink="/instituciones">Clubes</a></li>
                    <li routerLinkActive="active"><a class ="lime accent-4" routerLink="/usuarios">Usuarios</a></li>
                    <li routerLinkActive="active"><a class ="yellow accent-4" routerLink="/instituciones">Pruebas</a></li>
                    <li routerLinkActive="active"><a class ="orange accent-4" routerLink="/olimpiadas">Olimpiadas</a></li>
                    <li routerLinkActive="active"><a class ="red accent-4"  routerLink="/preguntas">Preguntas</a></li>
                    <li><a class ="red accent-4" href="/logout">Cerrar Sesión</a></li>
                </ul>
                <ul id="mobile-demo" class="side-nav" id="slide-out">
                    <li routerLinkActive="active"><a class ="purple darken-2" routerLink="/signup">Crear Usuario</a></li>
                    <li routerLinkActive="active"><a class ="light-blue accent-4" routerLink="/signin">Iniciar Sesión</a></li>
                    <li routerLinkActive="active"><a class ="teal accent-4" routerLink="/instituciones">Instituciones</a></li>
                    <li routerLinkActive="active"><a class ="green accent-4" routerLink="/instituciones">Instituciones</a></li>
                    <li routerLinkActive="active"><a class ="lime accent-4" routerLink="/instituciones">Instituciones</a></li>
                    <li routerLinkActive="active"><a class ="yellow accent-4" routerLink="/instituciones">Instituciones</a></li>
                    <li routerLinkActive="active"><a class ="orange accent-4" routerLink="/instituciones">Instituciones</a></li>
                    <li><a class ="red accent-4" href="/logout">Cerrar Sesión</a></li>
                </ul>
            </div>
        </nav>
        <router-outlet></router-outlet>
    `
})
export class AppComponent { 
    
}
