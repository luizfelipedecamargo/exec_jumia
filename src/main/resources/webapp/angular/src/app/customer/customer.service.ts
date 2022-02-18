import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Customer } from './customer';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private customersUrl: string;

  constructor(private http: HttpClient) { 
    this.customersUrl = 'http://localhost:8080/customer/listAll';
  }

  public findAll(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.customersUrl);
  }  

}
