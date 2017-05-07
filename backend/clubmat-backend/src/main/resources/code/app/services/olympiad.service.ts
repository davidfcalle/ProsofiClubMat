import { Injectable }    from '@angular/core';

import  { Olimpiada } from '../models/olympiad';
import  { Usuario } from '../models/usuario';
import  { Result } from '../models/result';

import * as request from "superagent";

import {Http, Response} from '@angular/http';
import {Observable, Subject} from 'rxjs/Rx';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

@Injectable()
export class OlympiadService {

  constructor(http: Http){}

  createOlympiad(olympiad: Olimpiada, grade: number): Promise<Olimpiada> {
      return new Promise<Olimpiada>((resolve, reject) => {
         request.post('/api/olimpiadas?grade='+grade)
            .send(olympiad)
            .set('Accept', 'application/json')
            .end((err, res) =>{
              if(err){
                reject(null)
              }else{
                if(res.status == 204)
                  reject('No preguntas suficientes para ese curso');
                else
                  resolve(res.body as Olimpiada)
              }
            });
      });
    }

    getOlympiadList(): Promise<Olimpiada[]>{
      return new Promise<Olimpiada[]>((resolve, reject)=>{
         request
          .get(`/api/olimpiada?size=999999&projection=full`)
          .set('Accept', 'application/json')
          .end((err, res) => {
            if(err){
              reject(null);
            }else{
              if(res.body == null){ // a pesar de que salio bien retorno un body nulo
                reject(err);
              }
              resolve(res.body._embedded.olimpiadas as Olimpiada[]);
            }
          });
      });
    }

    getOlympiad(id: number): Promise<Olimpiada>{
      return new Promise<Olimpiada>((resolve, reject) => {
        request
          .get(`/api/olimpiada/${id}?projection=full`)
          .set('Accept', 'application/json')
          .end((err, res) => {
            if(err){
              reject(null);
            }else{
              if(res.body == null){ // a pesar de que salio bien retorno un body nulo
                reject(err);
              }
              resolve(res.body as Olimpiada);
            }
          });
      });
    }

    updateOlympiad(olympiad: Olimpiada): Promise<Olimpiada>{
      return new Promise<Olimpiada>((resolve, reject) => {
        request
          .put(`/api/olimpiada/${olympiad.idolimpiada}`)
          .send(olympiad)
          .set('Accept', 'application/json')
          .end((err, res) => {
            if(err){
              reject(null);
            }else{
              if(res.body == null){ // a pesar de que salio bien retorno un body nulo
                reject(err);
              }
              resolve(res.body as Olimpiada);
            }
          });
      })
    }

    deleteOlympiad(olympiad: Olimpiada): Promise<boolean>{
      return new Promise<boolean>((resolve, reject) => {
        request
          .delete(`/api/olimpiada/${olympiad.idolimpiada}`)
          .send(olympiad)
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

    suscribeToOlympiad(olympiad: Olimpiada){
      return new Promise<Olimpiada>((resolve,reject) =>{
        request.post("/api/olimpiada/suscribe")
          .send(olympiad)
          .set('Accept', 'application/json')
          .end((err, res) =>{
            if(err){
              reject(null);
              return;
            }
            resolve(res.body as Olimpiada);
          });
      });
    }

    isSuscribe(id: number){
      return new Promise<Object>((resolve,reject) =>{
        request.get("/api/olimpiada/issuscribe?id="+id)
          .set('Accept', 'application/json')
          .end((err, res) =>{
            if(err){
              reject(null);
              return;
            }
            resolve(JSON.stringify(res.body) as string);
          });
      });
    }

    unSuscribeToOlympiad(olympiad: Olimpiada){
      return new Promise<Olimpiada>((resolve,reject) =>{
        request.post("/api/olimpiada/unsuscribe")
          .send(olympiad)
          .set('Accept', 'application/json')
          .end((err, res) =>{
            if(err){
              reject(null);
              return;
            }
            resolve(res.body as Olimpiada);
          });
      });
    }

    getUserList(id: number){
      return new Promise<Usuario[]>((resolve,reject) =>{
        request.get(`/api/olimpiada/${id}/usuarioList`)
          .set('Accept', 'application/json')
          .end((err, res) =>{
            if(err){
              reject(null);
              return;
            }
            resolve(res.body._embedded.usuarios as Usuario[]);
          });
      });
    }

    getResultList(id:number): Promise<Result[]>{
      return new Promise<Result[]>((resolve, reject)=>{
         request
          .get(`/api/olimpiada/results?idolympiad=${id}`)
          .set('Accept', 'application/json')
          .end((err, res) => {
            if(err){
              reject(null);
            }else{
              if(res.body == null){ // a pesar de que salio bien retorno un body nulo
                reject(err);
              }
              resolve(res.body as Result[]);
            }
          });
      });
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }
}