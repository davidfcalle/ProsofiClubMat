import { Injectable }    from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';
import  { Usuario } from '../models/usuario';
import * as request from "superagent";

@Injectable()
export class UserService {

    private usersUrl: string = '/api/usuario';
    private headers: Headers;

    constructor(private http: Http){ 
        this.headers = new Headers();
        this.headers.append('Content-Type', 'application/json;charset=utf-8');
    }

    createUser(user: Usuario): Promise<Usuario> {
      return new Promise<Usuario>((resolve, reject) => {
         request.post('/api/usuario/')
            .send(user)
            .set('Accept', 'application/json')
            .end((err, res) =>{
              if(err){
                reject(null)
              }else{
                resolve(res.body as Usuario)
              }
            });
      });
    }

    getUserList(): Promise<Usuario[]>{
      return new Promise<Usuario[]>((resolve, reject)=>{
         request
          .get(`/api/usuario/?size=999999`)
          .set('Accept', 'application/json')
          .end((err, res) => {
            if(err){
              reject(null);
            }else{
              if(res.body == null){ // a pesar de que salio bien retorno un body nulo
                reject(err);
              }
              resolve(res.body._embedded.usuarios as Usuario[]);
            }
          });
      });
    }

    getUser(id: number): Promise<Usuario>{
      return new Promise<Usuario>((resolve, reject) => {
        request
          .get(`/api/usuario/${id}`)
          .set('Accept', 'application/json')
          .end((err, res) => {
            if(err){
              reject(null);
            }else{
              if(res.body == null){ // a pesar de que salio bien retorno un body nulo
                reject(err);
              }
              resolve(res.body as Usuario);
            }
          });
      });
    }

    updateUser(user: Usuario): Promise<Usuario>{
      return new Promise<Usuario>((resolve, reject) => {
        request
          .put(`/api/usuario/${user.idusuario}`)
          .send(user)
          .set('Accept', 'application/json')
          .end((err, res) => {
            if(err){
              reject(null);
            }else{
              if(res.body == null){ // a pesar de que salio bien retorno un body nulo
                reject(err);
              }
              resolve(res.body as Usuario);
            }
          });
      })
    }

    deleteUser(user: Usuario): Promise<boolean>{
      return new Promise<boolean>((resolve, reject) => {
        request
          .delete(`/api/usuario/${user.idusuario}`)
          .send(user)
          .set('Accept', 'application/json')
          .end((err, res) => {
            if(err){
              reject(false);
            }else{
              if(res.body == null){ // a pesar de que salio bien retorno un body nulo
                resolve(true);
              }
              resolve(true);
            }
          });
      })
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }
}