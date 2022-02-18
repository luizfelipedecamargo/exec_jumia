package com.jumia.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumia.entities.Country;
import com.jumia.repositories.CountryRepository;
import com.jumia.service.CountryService;

@Service
public class CountryServiceImpl  implements CountryService{

	private CountryRepository countryRepository;
	
	@Autowired
	public CountryServiceImpl(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}	
	
	@Override
	public Iterable<Country> findAllCountries() {
		return countryRepository.findAll();
	}

	@Override
	public Country findCountryById(long countryId) {
		return countryRepository.findCountryById(countryId);
	}	
	
	@Override
	public Country findCountryByName(String countryName) {
		return countryRepository.findCountryByName(countryName);
	}

	@Override
	public void addCountry(Country country) {
		countryRepository.save(country);	
	}

	@Override
	public void updCountry(Country country) {
		
		Country updatedCountry = countryRepository.findCountryById(country.getCountryId());		
		
		updatedCountry.setCountryName(country.getCountryName());
		countryRepository.save(updatedCountry);
		
	}

	@Override
	public void delCountry(long countryId) {		
		countryRepository.deleteById(countryId);
		
	}



}
