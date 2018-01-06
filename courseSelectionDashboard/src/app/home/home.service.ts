import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/map';

import { Course } from '../entity'
 
const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
 
@Injectable()
export class HomeService {
 
    constructor(private http:HttpClient) {}
 
    // Uses http.get() to load data from a single API endpoint
    retrieveCourses() {
        return this.http.get<Array<Course>>('http://localhost:8080/courseSelection/retrieveCourse', httpOptions);
    }

    addCourses(coursename) {
        let body = JSON.stringify({courseName: coursename});
        return this.http.post<Array<Course>>('http://localhost:8080/courseSelection/addCourse', body, httpOptions);
    }

    handleError(data){
        console.log(data)
        var result = new Array<string>();
        result.push('failed');
        return result;
    }
}