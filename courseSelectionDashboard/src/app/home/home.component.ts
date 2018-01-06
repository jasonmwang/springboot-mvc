import { Component, OnInit } from '@angular/core';
import { trigger, style, transition, animate, keyframes, query, stagger } from '@angular/animations'
import { Router } from '@angular/router'; 
import { HomeService } from './home.service'
import { Course } from '../entity';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
  providers: [ HomeService ],
  animations: [
    trigger('courses', [
      transition('* => *', [
        query(':enter', style({ opacity: 0 }), {optional: true}),
        query(':enter', stagger('300ms', [
          animate('.6s ease-in', keyframes([
            style({opacity: 0, transform: 'translateY(-75%)', offset: 0}),
            style({opacity: .5, transform: 'translateY(35px)', offset: .3}),
            style({opacity: 1, transform: 'translateY(0)', offset: 1}),
          ]))
        ]), {optional: true}),
        query(':leave', stagger('300ms', [
          animate('.6s ease-in', keyframes([
            style({opacity: 1, transform: 'translateY(0)', offset: 0}),
            style({opacity: .5, transform: 'translateY(35px)', offset: .3}),
            style({opacity: 0, transform: 'translateY(-75%)', offset: 1}),
          ]))
        ]), {optional: true})
      ])
    ])
  ]
})
export class HomeComponent implements OnInit {

  courseCount: number;
  courseText: string;
  courselist: Array<Course> = new Array<Course>();
  constructor(private homeService : HomeService, private route : Router) { }

  ngOnInit() {
    this.homeService.retrieveCourses().subscribe(data => {
      this.courselist = data;
      this.courseCount = this.courselist.length;
    }, err => {
      console.log(err);
    });
  }

  addCourse(){
    var course = new Course();
    course.courseName = this.courseText;
    this.courselist.push(course);
    this.courseCount = this.courselist.length;
    this.courseText = '';
  }

  addCourseToStudent(course){
    
  }
}
