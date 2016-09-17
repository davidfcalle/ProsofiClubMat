import { Component } from '@angular/core';

@Component({
    selector: 'app',
    template: `
        <nav>
            <div class="nav-wrapper">
                <a href="#!" class="brand-logo center">ClubMat</a>
                <ul class="left hide-on-med-and-down">
                    <li routerLinkActive="active"><a routerLink="/signup">Crear Usuario</a></li>
                    <li routerLinkActive="active"><a routerLink="/signin">Iniciar Sesión</a></li>
                    <li routerLinkActive="active"><a href="#collapsible.html">CU 2</a></li>
                </ul>
            </div>
        </nav>
        <router-outlet></router-outlet>
    `
})
export class AppComponent { 
    
}
