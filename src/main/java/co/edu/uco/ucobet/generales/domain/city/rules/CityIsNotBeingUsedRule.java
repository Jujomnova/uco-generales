package co.edu.uco.ucobet.generales.domain.city.rules;

import co.edu.uco.ucobet.generales.domain.DomainRule;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import org.springframework.stereotype.Component;

@Component
public interface CityIsNotBeingUsedRule extends DomainRule<CityDomain> {

}