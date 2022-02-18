import { Component, ViewChild } from '@angular/core';

import { Country } from './country/country';
import { State } from './state/state';
import { Customer } from './customer/customer';

import { CountryService } from './country/country.service';
import { StateService } from './state/state.service';
import { CustomerService } from './customer/customer.service';

import { UtilService } from './util/util.service';

import { ColumnMode } from '@swimlane/ngx-datatable';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  @ViewChild('tbdados')
  table: any;
  ColumnMode = ColumnMode;

  countries: Country[] = [];
  countriesFilter: Country[] = [];

  states: State[] = [];
  statesFilter: State[] = [];

  customers: Customer[] = [];
  customersFilter: Customer[] = [];

  constructor(
    private countryService: CountryService,
    private stateService: StateService,
    private customerService: CustomerService,
    public utilService: UtilService,
    private util: UtilService
  ) { }

  getData(tab: number) {
    switch (tab) {
      case 1:
        this.countryService.findAll()
          .subscribe(data => {
            this.countries = []
            this.countries = data
            setTimeout(() => {
              this.countriesFilter = [...data];
              this.countries = [...data];
            }, 900);
          })
        break;
      case 2:
        this.stateService.findAll()
          .subscribe(data => {
            this.states = []
            this.states = data
            setTimeout(() => {
              this.statesFilter = [...data];
              this.states = [...data];
            }, 900);
          })
        break;
      case 3:
        this.customerService.findAll()
          .subscribe(data => {
            this.customers = []
            this.customers = data
            console.log(this.customers)
            setTimeout(() => {
              this.customersFilter = [...data];
              this.customers = [...data];
            }, 900);
          })
        break;

      default:
        break;
    }
  }


  updateFilter(event: any, tab: number) {

    const val = event.target.value.toLowerCase();
    let foundValue = null;

    switch (tab) {
      case 1:

        foundValue = this.countriesFilter.filter(function (data: any) {
          return data.countryId.toString().
            concat(data.countryName.toString()).
            trim().toLowerCase().
            indexOf(val) !== -1 || !val;
        });

        this.countries = foundValue;
        break;

      case 2:
        foundValue = this.statesFilter.filter(function (data: any) {
          return data.country.countryId.toString().
            concat(data.country.countryName.toString()).
            concat(data.id.stateId.toString()).
            concat(data.stateName.toString()).
            trim().toLowerCase().
            indexOf(val) !== -1 || !val;
        });

        this.states = foundValue;
        break;

      case 3:
        foundValue = this.customersFilter.filter((data: any) => {
          return data.countryId.toString().
            concat(data.customerId.toString()).
            concat(data.customerName.toString()).
            concat(data.customerPhone.toString()).
            concat(data.state.stateName.toString()).
            concat(data.stateId.toString()).
            concat(data.state.country.countryName.toString()).
            concat(this.util.isValid(data.customerPhone.toString(), data.countryId)).
            trim().toLowerCase().
            indexOf(val) !== -1 || !val;
        });

        this.customers = foundValue;
        break;

      default:
        break;
    }

    this.table.offset = 0;

  }

  onPage(event: any) { }

}