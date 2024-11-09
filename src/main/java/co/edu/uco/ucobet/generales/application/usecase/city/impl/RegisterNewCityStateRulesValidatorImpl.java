package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityStateRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.rules.CityStateExistsRule;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;
import co.edu.uco.ucobet.generales.domain.state.rules.StateExistsRule;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsNotNullRule;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsValidRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class RegisterNewCityStateRulesValidatorImpl implements RegisterNewCityStateRulesValidator {
    private final CityStateExistsRule cityStateExistsRule;
    private final StateExistsRule stateDoesExistRule;
    private final StateIdIsValidRule stateIdIsNotDefaultValueRule;
    private final StateIdIsNotNullRule stateIdIsNotNullRule;
    private final StateIdIsValidRule stateIdIsValidRule;

    public RegisterNewCityStateRulesValidatorImpl(final CityStateExistsRule cityStateExistsRule,
                                                   final StateExistsRule stateDoesExistRule,
                                                   final StateIdIsValidRule stateIdIsNotDefaultValueRule,
                                                   final StateIdIsNotNullRule stateIdIsNotNullRule,
                                                   final StateIdIsValidRule stateIdIsValidRule) {
        this.cityStateExistsRule = cityStateExistsRule;
        this.stateDoesExistRule = stateDoesExistRule;
        this.stateIdIsNotDefaultValueRule = stateIdIsNotDefaultValueRule;
        this.stateIdIsNotNullRule = stateIdIsNotNullRule;
        this.stateIdIsValidRule = stateIdIsValidRule;
    }

    @Override
    public void validate(final UUID data) {
        stateIdIsNotNullRule.validate(data);
        stateIdIsNotDefaultValueRule.validate(data);
        stateIdIsValidRule.validate(data);
        cityStateExistsRule.validate(StateDomain.create(data));
        stateDoesExistRule.validate(data);
    }
}
