import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { Usuario } from '../models/usuario';
import * as request from "superagent";


@Injectable()
export class SignupGuard implements CanActivate {

    constructor(){

    }

    canActivate() : Promise<boolean>{
      return new Promise((resolve, reject) =>{
        request
          .get(`/api/currentUser/`)
          .set('Accept', 'application/json')
          .end((err, res) => {
                err ? reject(false) : resolve(true);
          });
      })
    }
}