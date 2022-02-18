package com.jumia.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jumia.entities.State;
import com.jumia.entities.StatePK;

public interface StateRepository extends CrudRepository<State, StatePK>{

	@Query(value = "SELECT s FROM State s WHERE UPPER(s.stateName) = UPPER(:stateName)")
	State findStateByName(@Param("stateName") String stateName);	
	
	@Query(value = "SELECT s FROM State s WHERE s.id = :statePK")
	State findStateById(@Param("statePK") StatePK statePK);	
	
}


