import { Injectable }    from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';
import  { Usuario } from '../models/usuario';

@Injectable()
export class UserService {

    private usersUrl: string = '/api/usuario';
    private headers: Headers;

    constructor(private http: Http){ 
        this.headers = new Headers();
        this.headers.append('Content-Type', 'application/json;charset=utf-8');
    }

    getUserList(page: number){

    }

    createUser(user: Usuario): Promise<Usuario> {
        console.log("Se intenta crear " + JSON.stringify(user));
        return this.http.post(this.usersUrl, JSON.stringify(user), {headers : this.headers})
                        .toPromise()
                        .then(response => response.json().data as Usuario)
                        .catch(this.handleError);
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }
}