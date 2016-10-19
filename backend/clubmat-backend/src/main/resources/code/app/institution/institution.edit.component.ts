import { Component, OnInit } from "@angular/core";
import { Router, ActivatedRoute, Params } from "@angular/router";
import { Institucion } from "../models/institucion";
import { InstitutionService} from "../services/institution.service";
import * as request from "superagent";

@Component({
    selector: 'institutionEdit',
    templateUrl: 'app/institution/institution.edit.component.html',
    styleUrls: ['app/institution/institution.component.css']
})
export class InstitutionEditComponent implements OnInit {
    
     institution : Institucion;

     constructor (private institutionService: InstitutionService, private route: ActivatedRoute, private router:Router){
         this.institution = new Institucion();
     }


      
    ngOnInit(): void {
        var curInstance = this;
        this.route.params.forEach( (params: Params ) =>{
          let id = +params['id'];
          request
            .get(`/api/institucion/${id}`)
            .end(function(err, res){
              if(err){
                alert("Error al obtener las instituciones");
                return;
              }
              var selected = res.body as Institucion;
              console.log("se va a editar" + JSON.stringify(selected))
              curInstance.institution = selected;
            }); 
          }
        )
    }

    onSubmit():void{
       this.saveInstitution();
    }

    saveInstitution(): void {
        var curInstance = this;
        request
            .put(`/api/institucion/${curInstance.institution.idinstitucion}`)
            .send(this.institution)
            .set('Accept', 'application/json')
            .end(function deleteInst(err: any, res: request.Response){
                if(err){
                     alert("Error al crear la institución; inténtelo nuevamente");
                }else{
                    alert("institución editada correctamente");
                    curInstance.router.navigate([`/instituciones`]);
                }
            });
    }
}
