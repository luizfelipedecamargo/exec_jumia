package com.jumia.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jumia.entities.State;
import com.jumia.exception.JumiaException;
import com.jumia.service.StateService;
import com.jumia.util.Util;

@RestController
@RequestMapping("/state")
@CrossOrigin(origins = "http://localhost:4200")
public class StateController {

	@Autowired
	StateService stateService;

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public @ResponseBody Iterable<State> statesFindAll() {
		return stateService.findAllStates();
	}	

	@RequestMapping(value = "/exist/{stateName}", method = RequestMethod.GET)
	public ResponseEntity<?> findStateByName(@PathVariable("stateName") String stateName) {

		State state = stateService.findStateByName(stateName); 

		if (Util.isEmpty(state)) {
			return new ResponseEntity<JumiaException>(new JumiaException(stateName + ": State Not Found "), HttpStatus.NOT_FOUND); 	
		} 

		return new ResponseEntity<State>(state, HttpStatus.OK); 
	}


	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> addState(@Valid @RequestBody State stateBody){

		if (!Util.isEmpty(stateService.findStateByName(stateBody.getStateName()))) {
			return new ResponseEntity<JumiaException>(new JumiaException("State Name Duplicated: State " + stateBody.getStateName() + " already exist."), HttpStatus.CONFLICT); 	
		}

		stateService.addState(stateBody);

		return new ResponseEntity<State>(stateBody, HttpStatus.CREATED); 

	}

	@RequestMapping(value = "/upd", method = RequestMethod.PUT)
	public ResponseEntity<?> updState(@Valid @RequestBody State stateBody){
		
		if (Util.isEmpty(stateService.findStateById(stateBody))) {
			return new ResponseEntity<JumiaException>(new JumiaException("State Update Error: State Id " + stateBody.getId().toString() + " Do Not Exist."), HttpStatus.NOT_FOUND); 	
		}

		stateService.updState(stateBody);

		return new ResponseEntity<State>(stateBody, HttpStatus.OK);		

	}
	
	@RequestMapping(value = "/del", method = RequestMethod.DELETE)
	public ResponseEntity<?> delState(@Valid @RequestBody State stateBody){
		
		if (Util.isEmpty(stateService.findStateById(stateBody))) {
			return new ResponseEntity<JumiaException>(new JumiaException("State Delete Error: State Id " + stateBody.getId().toString() + " Do Not Exist."), HttpStatus.NOT_FOUND); 	
		}	
		
		stateService.delState(stateBody);
		
		return new ResponseEntity<State>(HttpStatus.NO_CONTENT);
		
	}	
	
}
