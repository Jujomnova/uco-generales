package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameFormatIsValidException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameFormatIsValidRule;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public final class CityNameFormatIsValidRuleImpl implements CityNameFormatIsValidRule {

    private static final String NAME_FORMAT_REGEX = "^[A-Za-z\\s\\-]{2,}$";

    @Override
    public void validate(String data) {
        if (data.length() < 2) {
            throw CityNameFormatIsValidException.create(MessageCatalogStrategy.getMessageContent(MessageCode.MCIT0011));
        }
        Pattern pattern = Pattern.compile(NAME_FORMAT_REGEX);
        Matcher matcher = pattern.matcher(data);
        if (!matcher.matches()) {
            throw CityNameFormatIsValidException.create(MessageCatalogStrategy.getMessageContent(MessageCode.MCIT0005));
        }
    }
}
