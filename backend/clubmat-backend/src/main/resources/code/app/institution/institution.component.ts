import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Institucion } from "../models/institucion";
import { InstitutionService} from "../services/institution.service";
import * as request from "superagent";

@Component({
    selector: 'institutionList',
    templateUrl: 'app/institution/institution.component.html',
    styleUrls: ['app/institution/institution.component.css']
})

export class InstitutionListComponent implements OnInit {
    
     institutions : Institucion[];
     selectedIns : Institucion;

     constructor (private router: Router){

     }

     changeSelectedIntitution(institution: Institucion): void{
         this.selectedIns = institution;
         console.log("se cambia a " + this.selectedIns.nombre);
     }

     editCurrentInstitution(): void {
         if(this.selectedIns != null){
             this.router.navigate([`/instituciones/${this.selectedIns.idinstitucion}/editar`]);
         }else{
             alert("Por favor seleccione la institución a editar")
         }
         
     }

     getInstitutions(): void{
         var call = this;
         request
            .get('/api/institucion?size=99999')
            .end(function(err, res){
                if(err){
                    alert("Error al obtener las instituciones");
                    return;
                }
                var institutionsRes = res.body._embedded.instituciones as Institucion[]
                console.log(institutionsRes);
                call.institutions = institutionsRes;
            });
     }

     ngOnInit(): void {
         this.getInstitutions(); 
     }

    setInstitucion(ins: Institucion[]){
        this.institutions = ins;
    }

    deleteInstitution(){
        if(this.selectedIns == null){
            alert("Por favor seleccione una institución a eliminar");
        }
        else{
            var shouldDelete : boolean = confirm(`¿Esta seguro de borrar la institución ${this.selectedIns.nombre} ?` );
            if(shouldDelete){
                var curInstance = this;
                request
                    .delete(`/api/institucion/${curInstance.selectedIns.idinstitucion}`)
                    .send(this.selectedIns)
                    .set('Accept', 'application/json')
                    .end(function deleteInst(err: any, res: request.Response){
                        if(err){
                            alert("Error al eliminar la institución");
                        }else{
                            alert("Se eliminó la institución correctamente");
                            curInstance.getInstitutions();
                            curInstance.selectedIns = null;
                        }
                    });
            }
        }


    }

    goBack(){
        window.history.back();
    }
}
