import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CountryListComponent } from './country/country-list/country-list.component'; 
import { CustomerListComponent } from './customer/customer-list/customer-list.component';
import { StateListComponent } from './state/state-list/state-list.component';

const routes: Routes = [
  { path: 'contries', component: CountryListComponent },
  { path: 'states', component: StateListComponent },
  { path: 'customers', component: CustomerListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }