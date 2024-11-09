package co.edu.uco.ucobet.generales.domain.country.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryport.repository.CountryRepository;
import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;
import co.edu.uco.ucobet.generales.domain.country.rules.CountryIdDoesntExistRule;
import co.edu.uco.ucobet.generales.domain.country.rules.CountryIdIsNotNullRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CountryIdIsNotNullRuleImpl implements CountryIdIsNotNullRule {

    @Override
    public void validate(UUID id) {
        if (ObjectHelper.isNull(id)) {
            throw RuleUcobetException.create(
                    MessageCatalogStrategy.getMessageContent(MessageCode.MCOU0002),
                    MessageCatalogStrategy.getMessageContent(MessageCode.MCOU0002)
            );
        }
    }
}
