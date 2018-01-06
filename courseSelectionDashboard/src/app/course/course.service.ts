import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/do';
import { Student } from '../entity';

@Injectable()
export class CourseService {

    constructor(private http: HttpClient){}

    retrieveStudents(courseId){
        let myParams = new URLSearchParams();
        myParams.append('courseId', courseId);	
        const httpOptions = {
            headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
            params: {courseId: courseId}
        };
        
        return this.http.get<Array<Student>>('http://localhost:8080/courseSelection/retrieveStudents', httpOptions);
    }

    registerCourse(studentId, courseId){
        const httpOptions = {
            headers: new HttpHeaders({ 'Content-Type': 'application/json' })
        };
        let body = JSON.stringify({studentId: studentId, courseId: courseId});
        return this.http.post<Array<Student>>('http://localhost:8080/courseSelection/registerCourse', body, httpOptions);
    }
}