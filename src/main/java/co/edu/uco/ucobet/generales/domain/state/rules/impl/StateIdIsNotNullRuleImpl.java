package co.edu.uco.ucobet.generales.domain.state.rules.impl;

import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.state.exceptions.StateIdIsNotNullException;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsNotNullRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StateIdIsNotNullRuleImpl implements StateIdIsNotNullRule {

    @Override
    public void validate(UUID id) {
        if (ObjectHelper.isNull(id)) {
            throw StateIdIsNotNullException.create();
        }
    }
}
