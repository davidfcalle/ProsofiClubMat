import { Component } from '@angular/core';

@Component({
    selector: 'app',
    template: `
        <nav>
            <div class="nav-wrapper">
                <a href="#!" class="brand-logo">ClubMat</a>
                <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li routerLinkActive="active"><a class ="purple darken-2" routerLink="/signup">Crear Usuario</a></li>
                    <li routerLinkActive="active"><a class ="light-blue accent-4" routerLink="/signin">Iniciar Sesión</a></li>
                    <li routerLinkActive="active"><a class ="teal accent-4" routerLink="/instituciones">Instituciones</a></li>
                    <li routerLinkActive="active"><a class ="green accent-4" routerLink="/instituciones">Instituciones</a></li>
                    <li routerLinkActive="active"><a class ="lime accent-4" routerLink="/usuarios">Usuarios</a></li>
                    <li routerLinkActive="active"><a class ="yellow accent-4" routerLink="/instituciones">Instituciones</a></li>
                    <li routerLinkActive="active"><a class ="orange accent-4" routerLink="/instituciones">Instituciones</a></li>
                    <li routerLinkActive="active"><a class ="red accent-4"  routerLink="/instituciones">Instituciones</a></li>
                    <li><a class ="red accent-4" href="/logout">Cerrar Sesión</a></li>
                </ul>
                <ul id="mobile-demo" class="side-nav">
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
