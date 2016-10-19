import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Institucion } from "../models/institucion";
import { InstitutionService} from "../services/institution.service";
import * as request from "superagent";


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
    
    handleCreate(err: any, res: request.Response): void{
          if(err){
            alert("Error al crear la institución; inténtelo nuevamente");
          }else{
            var inst: Institucion = res.body as Institucion;
            alert(`institución ${inst.nombre} creada correctamente`);
            this.institution = new Institucion();
         }
    }

    saveInstitution(): void {
        var currentIntance : InstitutionCreateComponent = this; // para no perder la referencia dentro del callback
        request.post('/api/instituciones/')
            .send(this.institution)
            .set('Accept', 'application/json')
            .end(function  handleCreate(err: any, res: request.Response): void{
                if(err){
                    alert("Error al crear la institución; inténtelo nuevamente");
                }else{
                    var inst: Institucion = res.body as Institucion;
                    alert(`institución ${inst.nombre} creada correctamente`);
                    currentIntance.institution = new Institucion();
                    currentIntance.router.navigate(["/instituciones"]);
                }
             });
    }
}
