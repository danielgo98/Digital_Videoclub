import { Injectable } from '@angular/core';
import { User } from '../interfaces/user.interface';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, catchError } from 'rxjs';

@Injectable({providedIn: 'root'})
export class AuthService {

  private baseUrl: string = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  login(user: User): Observable<User> {
    return this.http.post<User>(this.baseUrl + '/user' + '/login', user);
  }

  register(user: User): Observable<User> {
    return this.http.post<User>(this.baseUrl + '/user/', user);
  }

}
