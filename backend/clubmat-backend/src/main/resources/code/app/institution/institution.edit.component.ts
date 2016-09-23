import { Component, OnInit } from "@angular/core";
import { Router, ActivatedRoute, Params } from "@angular/router";
import { Institucion } from "../models/institucion";
import { InstitutionService} from "../services/institution.service";

@Component({
    selector: 'institutionEdit',
    templateUrl: 'app/institution/institution.edit.component.html',
    styleUrls: ['app/institution/institution.component.css']
})

export class InstitutionEditComponent implements OnInit{
    
     institution : Institucion;

     constructor (private institutionService: InstitutionService, private route: ActivatedRoute, private router:Router){
         this.institution = new Institucion();
     }

    ngOnInit(): void {
        this.route.params.forEach( (params: Params ) =>{
                let id = +params['id'];
                this.institutionService
                    .getInstitution(id)
                    .then( inst => this.institution = inst ); 
            }
        )
    }



    
    onSubmit():void{
       this.saveInstitution();
    }

    saveInstitution(): void {
        var saved: boolean = this.institutionService.putInstitution(this.institution);
        if(saved){
            alert("institución editada correctamente");
            this.institution = new Institucion();
            this.router.navigate([`/instituciones`]);
        }else{
            alert("Error al crear la institución; inténtelo nuevamente");
        }
    }


}