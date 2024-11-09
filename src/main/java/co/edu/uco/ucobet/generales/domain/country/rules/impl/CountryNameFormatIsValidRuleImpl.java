package co.edu.uco.ucobet.generales.domain.country.rules.impl;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;
import co.edu.uco.ucobet.generales.domain.country.exceptions.CountryNameFormatIsValidException;
import co.edu.uco.ucobet.generales.domain.country.exceptions.CountryNameIsEmptyException;
import co.edu.uco.ucobet.generales.domain.country.rules.CountryIdDoesntExistRule;
import co.edu.uco.ucobet.generales.domain.country.rules.CountryNameFormatIsValidRule;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CountryNameFormatIsValidRuleImpl implements CountryNameFormatIsValidRule {

    private static final String NAME_REGEX = "^[A-Za-z\\s\\-]{2,}$";

    @Override
    public void validate(String name) {
        if (TextHelper.isEmpty(name)) {
            throw CountryNameIsEmptyException.create();
        }
        if (name.length() > 100) {
            throw CountryNameFormatIsValidException.create();
        }

        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);

        if (!matcher.matches()) {
            throw CountryNameFormatIsValidException.create();
        }
    }
}
