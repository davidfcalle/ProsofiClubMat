import { Injectable }    from '@angular/core';

import  { Pregunta, OpcionPregunta } from '../models/pregunta';
import * as request from "superagent";

@Injectable()
export class QuestionService {

  createQuestion(question: Pregunta): Promise<Pregunta> {
      return new Promise<Pregunta>((resolve, reject) => {
         request.post('/api/pregunta/')
            .send(question)
            .set('Accept', 'application/json')
            .end((err, res) =>{
              if(err){
                reject(null)
              }else{
                resolve(res.body as Pregunta)
              }
            });
      });
    }

    getQuestionList(): Promise<Pregunta[]>{
      return new Promise<Pregunta[]>((resolve, reject)=>{
         request
          .get(`/api/pregunta/?size=999999`)
          .set('Accept', 'application/json')
          .end((err, res) => {
            if(err){
              reject(null);
            }else{
              if(res.body == null){ // a pesar de que salio bien retorno un body nulo
                reject(err);
              }
              resolve(res.body._embedded.preguntas as Pregunta[]);
            }
          });
      });
    }

    getQuestion(id: number): Promise<Pregunta>{
      return new Promise<Pregunta>((resolve, reject) => {
        request
          .get(`/api/pregunta/${id}`)
          .set('Accept', 'application/json')
          .end((err, res) => {
            if(err){
              reject(null);
            }else{
              if(res.body == null){ // a pesar de que salio bien retorno un body nulo
                reject(err);
              }
              resolve(res.body as Pregunta);
            }
          });
      });
    }

    updateQuestion(question: Pregunta): Promise<Pregunta>{
      return new Promise<Pregunta>((resolve, reject) => {
        request
          .put(`/api/usuario/${question.idpregunta}`)
          .send(question)
          .set('Accept', 'application/json')
          .end((err, res) => {
            if(err){
              reject(null);
            }else{
              if(res.body == null){ // a pesar de que salio bien retorno un body nulo
                reject(err);
              }
              resolve(res.body as Pregunta);
            }
          });
      })
    }

    deleteQuestion(question: Pregunta): Promise<boolean>{
      return new Promise<boolean>((resolve, reject) => {
        request
          .delete(`/api/usuario/${question.idpregunta}`)
          .send(question)
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