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
}
