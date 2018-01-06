import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { CourseService } from './course.service';
import { Student, Course } from '../entity';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.scss'],
  providers: [ CourseService ]
})
export class CourseComponent implements OnInit {

  selectedCourse: any;
  students: Array<Student>;
  studentId: number;
  constructor(private courseService: CourseService, private route: ActivatedRoute) { 
    this.route.queryParams.subscribe( params => {
      console.log(params);
      this.selectedCourse = params;
    });
  }

  ngOnInit() {
    this.courseService.retrieveStudents(this.selectedCourse.id).subscribe(data => {
      console.log(data);
      this.students = data;
    })
  }

  registerCourse(){
    console.log(this.studentId);
    console.log(this.selectedCourse.id);
    this.courseService.registerCourse(this.studentId, this.selectedCourse.id).subscribe(data => {
      console.log(data);
      this.students = data;
    }, err => {
      console.log(err);
    });
  }
}
