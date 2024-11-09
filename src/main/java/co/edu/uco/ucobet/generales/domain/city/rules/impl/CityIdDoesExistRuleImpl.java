package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryport.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdDoesExistException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesExistRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class CityIdDoesExistRuleImpl implements CityIdDoesExistRule {

    private final CityRepository cityRepository;

    public CityIdDoesExistRuleImpl(final CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void validate(final UUID data) {
        if (!cityRepository.existsById(data)) {
            throw CityIdDoesExistException.create();
        }
    }
}
