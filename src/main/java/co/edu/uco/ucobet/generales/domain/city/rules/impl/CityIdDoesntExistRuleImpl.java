package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryport.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdDoesExistException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesntExistRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class CityIdDoesntExistRuleImpl implements CityIdDoesntExistRule {

    private final CityRepository cityRepository;

    public CityIdDoesntExistRuleImpl(final CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void validate(final UUID data) {
        if (cityRepository.existsById(data)) {
            throw CityIdDoesExistException.create();
        }
    }
}
