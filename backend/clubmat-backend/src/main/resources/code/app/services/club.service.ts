import { Injectable }    from '@angular/core';

import  { Club } from '../models/club';
import  { ClubDTO } from '../dto/clubDTO';

import * as request from "superagent";

@Injectable()
export class ClubService {

    getClubs(){
        return new Promise<ClubDTO[]>((resolve, reject) => {
            request.get('/api/mathclub')
                .set('Accept', 'application/json')
                .end((err, res) =>{
                    if(err){
                        reject(null)
                    }else{
                        resolve(res.body as ClubDTO[])
                    }
                });
            });
    }

    createClub(club: Club){
        return new Promise<Club>((resolve, reject)=> {
            request.post(`/api/mathclub/create?idinstitucion=${club.idinstitucion.idinstitucion}`)
                .send(club)
                .set('Accept','application/json')
                .end((err,res) => {
                    if(err){
                        reject(null)
                    }else{
                        resolve(res.body as Club)
                    }
                });
        });
    }

    updateClub(club: Club){
        return new Promise<Club>((resolve, reject)=> {
            request.put(`/api/club/${club.idclub}`)
                .send(club)
                .set('Accept','application/json')
                .end((err,res) => {
                    if(err){
                        reject(null)
                    }else{
                        resolve(res.body as Club)
                    }
                });
        });
    }
}