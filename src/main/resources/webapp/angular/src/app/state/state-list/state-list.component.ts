import { Component } from '@angular/core';
import { State } from '../state';
import { StateService } from '../state.service';

@Component({
  selector: 'app-state-list',
  templateUrl: './state-list.component.html',
  styleUrls: ['./state-list.component.css']
})
export class StateListComponent {

  states: State[] = [];

  constructor(
    private stateService: StateService
  ) { }

}
