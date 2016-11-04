import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { Usuario, ROL_ADMINISTRADOR, ROL_ESTUDIANTE, ROL_PROFESOR } from '../models/usuario';
import * as request from "superagent";


@Injectable()
export class AdminGuard implements CanActivate {

    constructor(){

    }

    canActivate() : Promise<boolean>{
      return new Promise((resolve, reject) =>{
        request
          .get(`/api/currentUser/`)
          .set('Accept', 'application/json')
          .end((err, res) => {
            if(err){
              reject(false);
            }else{
              if(res.body == null){
                alert("El usuario no tiene los permisos para ver esta funcionalidad");
                resolve(false);
              }
              else{
                var usr = res.body as Usuario;
                if(usr.rol == ROL_ADMINISTRADOR || usr.rol == ROL_PROFESOR){
                  resolve(true);
                }
                else{
                  alert("No tienes los permisos necesarios para acceder a esta funcionalidad");
                  resolve(false)
                }
              }
            }
          });
      })
    }
}