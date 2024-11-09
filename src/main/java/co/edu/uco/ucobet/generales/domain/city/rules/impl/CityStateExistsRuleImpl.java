package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryport.repository.StateRepository;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityStateDoesntExistException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityStateExistsRule;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;
import org.springframework.stereotype.Service;

@Service
public class CityStateExistsRuleImpl implements CityStateExistsRule {

    public StateRepository stateRepository;

    public CityStateExistsRuleImpl(final StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public void validate(StateDomain state) {
        if (!stateRepository.existsById(state.getId())) {
            throw CityStateDoesntExistException.create();
        }
    }
}
