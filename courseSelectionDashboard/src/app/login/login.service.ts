import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/map';
 
const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
 
@Injectable()
export class LoginService {
 
    constructor(private http:HttpClient) {}
 
    // Uses http.get() to load data from a single API endpoint
    login(username, pwd) {
        let body = JSON.stringify({name: username, passwd: pwd});
        return this.http.post<object>('http://localhost:8080/courseSelection/login', body, httpOptions).do(data => console.log(data));
    }

    handleError(data){
        console.log(data)
        return 'failed';
    }
}