import { Injectable }    from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';
import  { Usuario } from '../models/usuario';
import  { Test } from '../models/test';
import * as request from "superagent";

@Injectable()
export class UserService {

    private usersUrl: string = '/api/usuario';
    private headers: Headers;
    private currentUser: Usuario;

    constructor(private http: Http){ 
        this.headers = new Headers();
        this.headers.append('Content-Type', 'application/json;charset=utf-8');
        this.currentUser = null;
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

    getCurrentUser(): Promise<Usuario>{

      if(this.currentUser != null){
        return new Promise<Usuario>((resolve, reject)=>{
          resolve(this.currentUser);
        });
      }

      return new Promise<Usuario>((resolve, reject) => {
        request
          .get(`/api/currentUser/`)
          .set('Accept', 'application/json')
          .end((err, res) => {
            if(err){
              reject(null);
            }else{
              if(res.body == null){ // a pesar de que salio bien retorno un body nulo
                reject(err);
              }
              var current = res.body as Usuario;
              this.currentUser = current; // esto solo se debería calcular una vez por inicio de sesión
              resolve(current);
            }
          });
      });
    }

    getTestResults(user : Usuario): Promise<Test[]>{
      return new Promise<Test[]>((resolve, reject) =>{
        request
          .get(`/api/usuarios/${user.idusuario}/tests`)
          .set('Accept', 'application/json')
          .end((err, res) =>{
            if(err){
              reject(null);
              return;
            }
            resolve(res.body as Test[]);
          });
      });
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }
}
