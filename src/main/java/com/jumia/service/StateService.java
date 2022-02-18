package com.jumia.service;

import org.springframework.stereotype.Service;

import com.jumia.entities.State;

@Service
public interface StateService {

	public Iterable<State> findAllStates();
	public State findStateById(State state);
	public State findStateByName(String stateName); 
	public void addState(State state);
	public void updState(State state);
	public void delState(State state);
	
}
