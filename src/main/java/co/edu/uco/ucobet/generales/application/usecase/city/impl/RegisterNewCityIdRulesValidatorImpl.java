package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityIdRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdDoesntExistException;
import co.edu.uco.ucobet.generales.domain.city.rules.*;
import org.springframework.stereotype.Service;


@Service
public final class RegisterNewCityIdRulesValidatorImpl implements RegisterNewCityIdRulesValidator {

    private final CityIdDoesntExistRule cityIdDoesntExistRule;

    public RegisterNewCityIdRulesValidatorImpl(final CityIdDoesntExistRule cityIdDoesntExistRule) {
        this.cityIdDoesntExistRule = cityIdDoesntExistRule;
    }

    @Override
    public void validate(final CityDomain data) {
        data.generateId();
        try {
            cityIdDoesntExistRule.validate(data.getId());
        } catch (CityIdDoesntExistException exception) {
            validate(data);
        }
    }
}
