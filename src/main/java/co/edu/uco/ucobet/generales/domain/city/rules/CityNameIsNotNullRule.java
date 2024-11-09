package co.edu.uco.ucobet.generales.domain.city.rules;

import co.edu.uco.ucobet.generales.domain.DomainRule;
import org.springframework.stereotype.Component;

@Component
public interface CityNameIsNotNullRule extends DomainRule<String> {
}
