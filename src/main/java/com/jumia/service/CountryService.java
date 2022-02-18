package com.jumia.service;

import org.springframework.stereotype.Service;

import com.jumia.entities.Country;

@Service
public interface CountryService {

	public Iterable<Country> findAllCountries();
	public Country findCountryById(long countryId);
	public Country findCountryByName(String countryName); 
	public void addCountry(Country country);
	public void updCountry(Country country);
	public void delCountry(long countryId);
	
}
