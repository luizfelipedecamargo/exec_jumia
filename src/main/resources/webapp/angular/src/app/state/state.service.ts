import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { State } from './state';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StateService {

  private statesUrl: string;

  constructor(private http: HttpClient) { 
    this.statesUrl = 'http://localhost:8080/state/listAll';
  }

  public findAll(): Observable<State[]> {
    return this.http.get<State[]>(this.statesUrl);
  }  

}
