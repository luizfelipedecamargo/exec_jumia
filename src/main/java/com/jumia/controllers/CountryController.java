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

import com.jumia.entities.Country;
import com.jumia.exception.JumiaException;
import com.jumia.service.CountryService;
import com.jumia.util.Util;

@RestController
@RequestMapping("/country")
@CrossOrigin(origins = "http://localhost:4200")
public class CountryController {

	@Autowired
	CountryService countryService;

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public @ResponseBody Iterable<Country> countriesFindAll() {
		return countryService.findAllCountries();
	}	

	@RequestMapping(value = "/exist/{countryName}", method = RequestMethod.GET)
	public ResponseEntity<?> findCountryByName(@PathVariable("countryName") String countryName) {

		Country country = countryService.findCountryByName(countryName); 

		if (Util.isEmpty(country)) {
			return new ResponseEntity<JumiaException>(new JumiaException(countryName + ": Country Not Found "), HttpStatus.NOT_FOUND); 	
		} 

		return new ResponseEntity<Country>(country, HttpStatus.OK); 
	}


	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> addCountry(@Valid @RequestBody Country countryBody){

		if (!Util.isEmpty(countryService.findCountryById(countryBody.getCountryId()))) {
			return new ResponseEntity<JumiaException>(new JumiaException("Country Id Duplicated: Country " + countryBody.getCountryId() + " already exist."), HttpStatus.CONFLICT); 	
		}		
		
		if (!Util.isEmpty(countryService.findCountryByName(countryBody.getCountryName()))) {
			return new ResponseEntity<JumiaException>(new JumiaException("Country Name Duplicated: Country " + countryBody.getCountryName() + " already exist."), HttpStatus.CONFLICT); 	
		}

		countryService.addCountry(countryBody);

		return new ResponseEntity<Country>(countryBody, HttpStatus.CREATED); 

	}

	@RequestMapping(value = "/upd", method = RequestMethod.PUT)
	public ResponseEntity<?> updCountry(@Valid @RequestBody Country countryBody){

		if (Util.isEmpty(countryService.findCountryById(countryBody.getCountryId()))) {
			return new ResponseEntity<JumiaException>(new JumiaException("Country Update Error: Country Id " + countryBody.getCountryId() + " Do Not Exist."), HttpStatus.NOT_FOUND); 	
		}

		countryService.updCountry(countryBody);

		return new ResponseEntity<Country>(countryBody, HttpStatus.OK);		

	}
	
	@RequestMapping(value = "/del", method = RequestMethod.DELETE)
	public ResponseEntity<?> delCountry(@Valid @RequestBody Country countryBody){
		
		if (Util.isEmpty(countryService.findCountryById(countryBody.getCountryId()))) {
			return new ResponseEntity<JumiaException>(new JumiaException("Country Delete Error: Country Id " + countryBody.getCountryId() + " Do Not Exist."), HttpStatus.NOT_FOUND); 	
		}	
		
		countryService.delCountry(countryBody.getCountryId());
		
		return new ResponseEntity<Country>(HttpStatus.NO_CONTENT);
		
	}


}
