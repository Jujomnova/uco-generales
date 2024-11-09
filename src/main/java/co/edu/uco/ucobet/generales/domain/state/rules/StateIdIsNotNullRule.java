package co.edu.uco.ucobet.generales.domain.state.rules;

import co.edu.uco.ucobet.generales.domain.DomainRule;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface StateIdIsNotNullRule extends DomainRule<UUID> {
}
