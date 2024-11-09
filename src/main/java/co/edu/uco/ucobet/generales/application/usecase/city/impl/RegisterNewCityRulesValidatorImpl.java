package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityIdRulesValidator;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityNameRulesValidator;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityRulesValidator;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityStateRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class RegisterNewCityRulesValidatorImpl implements RegisterNewCityRulesValidator {

    private final RegisterNewCityIdRulesValidator registerNewCityIdRulesValidator;
    private final RegisterNewCityNameRulesValidator registerNewCityNameRulesValidator;
    private final RegisterNewCityStateRulesValidator registerNewCityStateRulesValidator;

    public RegisterNewCityRulesValidatorImpl(final RegisterNewCityIdRulesValidator registerNewCityIdRulesValidator,
                                             final RegisterNewCityNameRulesValidator registerNewCityNameRulesValidator,
                                             final RegisterNewCityStateRulesValidator registerNewCityStateRulesValidator) {
        this.registerNewCityIdRulesValidator = registerNewCityIdRulesValidator;
        this.registerNewCityNameRulesValidator = registerNewCityNameRulesValidator;
        this.registerNewCityStateRulesValidator = registerNewCityStateRulesValidator;
    }

    private void validateId(final CityDomain data) {
        registerNewCityIdRulesValidator.validate(data);
    }
    private void validateName(final CityDomain data) {
        registerNewCityNameRulesValidator.validate(data);
    }
    private void validateState(final UUID stateId) {
        registerNewCityStateRulesValidator.validate(stateId);
    }


    @Override
    public void validate(final CityDomain data) {
        validateId(data);
        validateName(data);
        validateState(data.getState().getId());
    }
}

