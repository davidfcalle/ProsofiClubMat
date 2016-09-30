import { Injectable }    from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';
import  { Institucion } from '../models/institucion';

const INSTITUTIONS: Institucion[] =  [
    {
        idinstitucion:1,
        nombre:"Jave",
        ciudad:"Bogotá",
        localidad:"USME",
        direccion:"dire",
        telefono: 123,
        rector:"Muti",
        tipo:"tipo"
    },
    {
        idinstitucion:2,
        nombre:"Distri",
        ciudad:"Bogotá",
        localidad:"USME",
        direccion:"dire",
        telefono: 123,
        rector:"Nix",
        tipo:"tipo"
    },
     {
        idinstitucion:666,
        nombre:"Prosofi",
        ciudad:"Bogotá",
        localidad:"Chapinero",
        direccion:"Calle Falsa 123",
        telefono: 3214992795,
        rector:"El Cura Pelaez",
        tipo:"tipazo"
    }

]


@Injectable()
export class InstitutionService {

    private institutionsUrl: string = '/api/instituciones/';
    private headers: Headers;

    constructor(private http: Http){ 
        this.headers = new Headers();
        this.headers.append('Content-Type', 'application/json;charset=utf-8');
    }

    getInstitutions(): Promise<Institucion[]> {
        return Promise.resolve(INSTITUTIONS);
    }

    saveInstitution(institution: Institucion): Promise<Institucion> {

        var promise : Promise<Institucion> = this.http.post(this.institutionsUrl, JSON.stringify(institution), {headers : this.headers})
                        .toPromise()
                        .then(response => response.json().data as Institucion)
                        .catch(error => error.message || error);
        return promise;
    }

    getInstitution(id: number): Promise<Institucion> {
        var retorno: Institucion = null;
        for(var ins of INSTITUTIONS){
            if(ins.idinstitucion == id){
                retorno = ins;
            }
        }
        return Promise.resolve(retorno);
    }


    putInstitution(edited:Institucion): boolean {
        var retorno: boolean = false;
        for(var ins of INSTITUTIONS){
            if(ins.idinstitucion == edited.idinstitucion){
                ins = edited;
                retorno = true;
            }
        }
        return retorno;
    }

    deleteInstitution(edited:Institucion): boolean {
        var retorno: boolean = false;
        for(var i = 0; i<INSTITUTIONS.length;i++){
            var ins : Institucion = INSTITUTIONS[i];
            if(ins.idinstitucion == edited.idinstitucion){
                INSTITUTIONS.splice(i,1);
                retorno = true;
            }
        }
        return retorno;
    }




}