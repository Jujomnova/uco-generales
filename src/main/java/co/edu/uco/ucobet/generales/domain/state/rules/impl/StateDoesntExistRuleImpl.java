package co.edu.uco.ucobet.generales.domain.state.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryport.repository.StateRepository;
import co.edu.uco.ucobet.generales.domain.state.exceptions.StateDoesExistException;
import co.edu.uco.ucobet.generales.domain.state.rules.StateDoesntExistRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StateDoesntExistRuleImpl implements StateDoesntExistRule {

    private final StateRepository stateRepository;

    public StateDoesntExistRuleImpl(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public void validate(UUID id) {
        if (stateRepository.existsById(id)) {
            throw StateDoesExistException.create();
        }
    }
}
