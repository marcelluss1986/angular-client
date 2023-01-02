import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { User } from './user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  username: string;
  password: string;
  loginError: boolean;
  signingUp: boolean;
  messageSuccess: string;
  errors: string[];



  constructor(
    private router: Router,
    private authService: AuthService
  ) { }

  onSubmit() {
    this.authService
      .trySignIn(this.username, this.password)
      .subscribe(response => {
        const access_token = JSON.stringify(response);
        localStorage.setItem('access_token', access_token)
        this.router.navigate(['/home'])
      }, errorResponse =>{
        this.errors = ['User and/or Password not valid']
      })
      
  }

  prepareSigningUp(event) {
    event.preventDefault();
    this.signingUp = true;
  }

  cancelRegister() {
    this.signingUp = false;
  }

  register() {
    const user = new User();
    user.username = this.username;
    user.password = this.password;
    this.authService
      .save(user)
      .subscribe(response => {
        this.messageSuccess = "Success for Register! Sign in Now!";
        this.signingUp = false;
        this.username = '';
        this.password = '';
        this.errors = [];
      }, errorResposnse => {
        this.messageSuccess = null;
        this.errors = errorResposnse.error.errors;
      })
  }

}
