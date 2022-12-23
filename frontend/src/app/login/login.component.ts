import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

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



  constructor(
    private router: Router
  ) {}

  onSubmit(){
    this.router.navigate(['/home'])
  }

  prepareSigningUp(event){
    event.preventDefault();
    this.signingUp = true;
  }

  cancelRegister(){
    this.signingUp = false;
  }

}
