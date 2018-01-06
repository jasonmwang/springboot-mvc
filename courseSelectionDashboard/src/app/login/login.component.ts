import { Component, OnInit } from '@angular/core';
import { LoginService } from './login.service'
import { Router } from '@angular/router'; 

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  providers: [ LoginService ]
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  hide: boolean = true;
  constructor(private loginService : LoginService, private route : Router) { }

  ngOnInit() {
  }

  login(){
    console.log(this.username + this.password);
    this.loginService.login(this.username, this.password).subscribe(data => {
      console.log(data);
      if(data && data['result'] && data['result'] == 'login-success'){
        this.route.navigate(['home']);
      }
    }, err => {
      console.log(err);
    });
  }
}
