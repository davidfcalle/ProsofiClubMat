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

     constructor (private institutionService: InstitutionService, private router: Router){

     }

     changeSelectedIntitution(institution: Institucion): void{
         this.selectedIns = institution;
         console.log("se cambia a " + this.selectedIns.nombre);
     }

     editCurrentInstitution(): void {
         this.router.navigate([`/instituciones/${this.selectedIns.idinstitucion}/editar`]);
     }

     ngOnInit(): void {
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

    setInstitucion(ins: Institucion[]){
        this.institutions = ins;
    }

    deleteInstitution(){
        if(this.selectedIns == null){
            alert("Por favor seleccione una institución a eliminar");
        }
        else{
            var siborre : boolean = confirm(`¿Esta seguro de borrar la institución ${this.selectedIns.nombre} ?` );
            if(siborre){
                this.institutionService.deleteInstitution(this.selectedIns);
            }
        }


    }

    goBack(){
        window.history.back();
    }




}
