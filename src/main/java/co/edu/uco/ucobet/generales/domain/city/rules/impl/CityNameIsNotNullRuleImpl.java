package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameIsNotNullException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotNullRule;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public final class CityNameIsNotNullRuleImpl implements CityNameIsNotNullRule {
    @Override
    public void validate(String data) {
        if (ObjectHelper.isNull(data)) {
            throw CityNameIsNotNullException.create();
        }
    }
}
