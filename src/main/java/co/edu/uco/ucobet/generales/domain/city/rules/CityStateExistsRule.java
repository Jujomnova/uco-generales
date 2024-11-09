package co.edu.uco.ucobet.generales.domain.city.rules;

import co.edu.uco.ucobet.generales.domain.DomainRule;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;
import org.springframework.stereotype.Component;

@Component
public interface CityStateExistsRule extends DomainRule<StateDomain> {
}
