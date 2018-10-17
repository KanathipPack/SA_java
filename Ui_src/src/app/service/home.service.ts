import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { User } from '../teacher/user.model';
@Injectable(
{
  providedIn: 'root'

})

export class Homeservice{
public API = '//localhost:8080';
    constructor(private http: HttpClient) { }

     getTeacher(): Observable<any> {
    return this.http.get(this.API + '/Teachers');
  }
    getRoom():  Observable<any> {
    return this.http.get(this.API + '/Rooms');
  }
    getSubject(): Observable<any> {
    return this.http.get(this.API + '/Subjects');
  }

  getStudyTimeTable(): Observable<any> {
    return this.http.get(this.API + '/Studytimetables');
  }

  public getUsers() {
    return this.http.get<User[]>(this.API+'/Teachers');
  }
}
