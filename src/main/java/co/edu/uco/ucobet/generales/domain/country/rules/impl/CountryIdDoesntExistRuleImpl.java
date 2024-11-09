package co.edu.uco.ucobet.generales.domain.country.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryport.repository.CountryRepository;
import co.edu.uco.ucobet.generales.domain.country.exceptions.CountryIdDoesntExistException;
import co.edu.uco.ucobet.generales.domain.country.rules.CountryIdDoesntExistRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CountryIdDoesntExistRuleImpl implements CountryIdDoesntExistRule {

    private final CountryRepository countryRepository;

    public CountryIdDoesntExistRuleImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public void validate(UUID id) {
        if (countryRepository.existsById(id)) {
            throw CountryIdDoesntExistException.create();
        }
    }
}
