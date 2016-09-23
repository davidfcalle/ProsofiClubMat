import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Institucion } from "../models/institucion";
import { InstitutionService} from "../services/institution.service";

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
        this.institutionService
             .getInstitutions()
             //.then(this.setInst)
             .then(institutions => this.institutions = institutions);
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
