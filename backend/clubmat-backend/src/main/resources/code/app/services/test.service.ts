import { Injectable }    from '@angular/core';

import  { Test } from '../models/test';

import { CreateTestDTO } from '../dto/CreateTestDTO';

import * as request from "superagent";

@Injectable()
export class TestService {

  createTest(test: CreateTestDTO) {
    return new Promise<Test>((resolve, reject) => {
      request.post('/api/test/')
        .send(test)
        .set('Accept', 'application/json')
        .end((err, res) =>{
          if(err){
            reject(null)
          }else{
            resolve(res.body as Test)
          }
        });
    });
  }

  getTest(id: number){
    return new Promise<Test>((resolve, reject) => {
      request.get(`/api/prueba/${id}/?projection=preguntas`)
        .set('Accept', 'application/json')
        .end((err, res) =>{
          if(err){
            reject(null)
          }else{
            resolve(res.body as Test)
          }
        });
    });
  }

  updateTest(test: Test): Promise<Test>{
      return new Promise<Test>((resolve, reject) => {
        request
          .put(`/api/test`)
          .send(test)
          .set('Accept', 'application/json')
          .end((err, res) => {
            if(err){
              reject(null);
            }else{
              if(res.body == null){ // a pesar de que salio bien retorno un body nulo
                reject(err);
              }
              resolve(res.body as Test);
            }
          });
      })
    }

    hasTaken(id:number){
      return new Promise<Object>((resolve,reject) =>{
        request.get("/api/test/hastaken?id="+id)
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

}
