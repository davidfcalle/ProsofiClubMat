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

    receiveInst(inst : Institucion ):void{
            alert(`institución ${inst.nombre} creada correctamente`);
            this.router.navigate([`/instituciones`]);
    }

    errorInst():void{
        alert("Error al crear la institución; inténtelo nuevamente");
    }

    saveInstitution(): void {
        var promise : Promise<Institucion> = this.institutionService.saveInstitution(this.institution);
        promise.then(this.receiveInst).catch(this.errorInst);

    }
}
