import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Institucion } from "../models/institucion";
import { InstitutionService} from "../services/institution.service";

@Component({
    selector: 'institutionCreate',
    templateUrl: 'app/institution/institution.create.component.html',
    styleUrls: ['app/institution/institution.component.css']
})

export class InstitutionCreateComponent {
    
     institution : Institucion;

     constructor (private institutionService: InstitutionService, private router:Router){
         this.institution = new Institucion();
     }

    onSubmit():void{
       this.saveInstitution();
    }

    saveInstitution(): void {
        var saved: boolean = this.institutionService.saveInstitution(this.institution);
        if(saved){
            alert("institución creada correctamente");
            this.router.navigate([`/instituciones`]);
            
        }else{
            alert("Error al crear la institución; inténtelo nuevamente");
        }
    }
}
