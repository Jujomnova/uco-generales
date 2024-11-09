package co.edu.uco.ucobet.generales.domain.country.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryport.repository.CountryRepository;
import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;
import co.edu.uco.ucobet.generales.domain.country.rules.CountryIdDoesntExistRule;
import co.edu.uco.ucobet.generales.domain.country.rules.CountryIdExistsRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CountryIdExistsRuleImpl implements CountryIdExistsRule {

    private final CountryRepository countryRepository;

    public CountryIdExistsRuleImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public void validate(UUID id) {
        if (!countryRepository.existsById(id)) {
            throw RuleUcobetException.create(
                    MessageCatalogStrategy.getMessageContent(MessageCode.MCOU0000),
                    MessageCatalogStrategy.getMessageContent(MessageCode.MCOU0000)
            );
        }
    }
}
