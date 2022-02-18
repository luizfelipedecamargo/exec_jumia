package com.jumia.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumia.entities.State;
import com.jumia.repositories.StateRepository;
import com.jumia.service.StateService;

@Service
public class StateServiceImpl  implements StateService{

	private StateRepository stateRepository;
	
	@Autowired
	public StateServiceImpl(StateRepository stateRepository) {
		this.stateRepository = stateRepository;
	}	
	
	@Override
	public Iterable<State> findAllStates() {
		return stateRepository.findAll();
	}

	@Override
	public State findStateById(State state) {
		return stateRepository.findStateById(state.getId());
	}	
	
	@Override
	public State findStateByName(String stateName) {
		return stateRepository.findStateByName(stateName);
	}

	@Override
	public void addState(State state) {
		stateRepository.save(state);	
	}

	@Override
	public void updState(State state) {
		
		State updatedState = stateRepository.findStateById(state.getId());		
		
		updatedState.setStateName(state.getStateName());
		stateRepository.save(updatedState);
		
	}

	@Override
	public void delState(State state) {		
		stateRepository.deleteById(state.getId());
		
	}



}
