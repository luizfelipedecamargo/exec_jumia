import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { CountryListComponent } from './country/country-list/country-list.component';
import { CountryService } from './country/country.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCardModule } from '@angular/material/card';
import { MatTabsModule } from '@angular/material/tabs';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { NgxDatatableModule } from '@swimlane/ngx-datatable';
import { StateListComponent } from './state/state-list/state-list.component';
import { CustomerListComponent } from './customer/customer-list/customer-list.component';
import { StateService } from './state/state.service';
import { CustomerService } from './customer/customer.service';
import { UtilService } from './util/util.service';

@NgModule({
  declarations: [
    AppComponent,
    CountryListComponent,
    StateListComponent,
    CustomerListComponent
  ],
  exports: [
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatTabsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatIconModule,
    NgxDatatableModule,
  ],
  providers: [
    CountryService, 
    StateService, 
    CustomerService,
    UtilService],
  bootstrap: [AppComponent]
})
export class AppModule { }