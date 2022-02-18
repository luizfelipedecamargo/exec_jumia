package com.jumia.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jumia.entities.Country;

public interface CountryRepository extends CrudRepository<Country, Long>{

	@Query(value = "SELECT c FROM Country c WHERE UPPER(c.countryName) = UPPER(:countryName)")
	Country findCountryByName(@Param("countryName") String countryName);	
	
	@Query(value = "SELECT c FROM Country c WHERE c.countryId = :countryId")
	Country findCountryById(@Param("countryId") long countryId);	


}


