package co.edu.uco.ucobet.generales.domain.state.rules.impl;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.domain.state.exceptions.StateNameEmptyException;
import co.edu.uco.ucobet.generales.domain.state.exceptions.StateNameInvalidException;
import co.edu.uco.ucobet.generales.domain.state.exceptions.StateNameTooLongException;
import co.edu.uco.ucobet.generales.domain.state.rules.StateNameIsValidRule;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class StateNameIsValidRuleImpl implements StateNameIsValidRule {

    private static final String NAME_REGEX = "^[A-Za-z\\s\\-]{2,}$";

    @Override
    public void validate(String name) {
        if (TextHelper.isEmpty(name)) {
            throw StateNameEmptyException.create();
        }

        if (name.length() > 200) {
            throw StateNameTooLongException.create();
        }

        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);

        if (!matcher.matches()) {
            throw StateNameInvalidException.create();
        }
    }
}
