import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Country } from './country';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CountryService {

  private countriesUrl: string;

  constructor(private http: HttpClient) { 
    this.countriesUrl = 'http://localhost:8080/country/listAll';
  }

  public findAll(): Observable<Country[]> {
    return this.http.get<Country[]>(this.countriesUrl);
  }  

}
