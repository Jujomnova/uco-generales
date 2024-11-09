package co.edu.uco.ucobet.generales.domain.country.rules.impl;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;
import co.edu.uco.ucobet.generales.domain.country.rules.CountryIdIsValidRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CountryIdIsValidRuleImpl implements CountryIdIsValidRule {

    @Override
    public void validate(UUID id) {
        if (TextHelper.isEmpty(id.toString())) {
            throw RuleUcobetException.create(
                    MessageCatalogStrategy.getMessageContent(MessageCode.MCOU0004),
                    MessageCatalogStrategy.getMessageContent(MessageCode.MCOU0004)
            );
        }

        if (UUIDHelper.isDefault(id)) {
            throw RuleUcobetException.create(
                    MessageCatalogStrategy.getMessageContent(MessageCode.MCOU0004),
                    MessageCatalogStrategy.getMessageContent(MessageCode.MCOU0004)
            );
        }
    }
}
