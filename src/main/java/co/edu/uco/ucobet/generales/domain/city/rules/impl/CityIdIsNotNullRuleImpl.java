package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryport.repository.CityRepository;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdIsNotNullException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIsNotNullRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class CityIdIsNotNullRuleImpl implements CityIdIsNotNullRule {

    public final CityRepository cityRepository;

    public CityIdIsNotNullRuleImpl(final CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void validate(UUID data) {
        if (ObjectHelper.isNull(data)) {
            throw CityIdIsNotNullException.create();
        }
    }
}
