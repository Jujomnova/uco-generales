package co.edu.uco.ucobet.generales.domain.state.rules.impl;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.domain.state.exceptions.StateIdIsNotDefaultValueException;
import co.edu.uco.ucobet.generales.domain.state.exceptions.StateIdIsNotEmptyException;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsValidRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StateIdIsValidRuleImpl implements StateIdIsValidRule {

    @Override
    public void validate(UUID id) {
        if (TextHelper.isEmpty(id.toString())) {
            throw StateIdIsNotEmptyException.create();
        }

        if (UUIDHelper.isDefault(id)) {
            throw StateIdIsNotDefaultValueException.create();
        }
    }
}
