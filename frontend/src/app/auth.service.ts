import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { environment } from '../environments/environment';
import { User } from './login/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  apiURL: string = environment.apiURL + "/api/users";
  tokenUrl: string = environment.apiURL + environment.tokenUrl;
  clientId: string = environment.clientId;
  clientSecret: string = environment.clientSecret;

  constructor(
    private http: HttpClient
  ) { }

  save(user: User): Observable<any> {
    return this.http.post<any>(this.apiURL, user);
  }

  trySignIn(username: string, password: string): Observable<any> {
    const params = new HttpParams()
      .set('username', username)
      .set('password', password)
      .set('grant_type', 'password')
    const headers = {
      'Authorization': 'Basic' + btoa(`${this.clientId}:${this.clientSecret}` ),
      'Content-Type': 'application/x-www-form-urlencoded'
    }
    return this.http.post(this.tokenUrl,params.toString , {headers});
  }
}
