package co.edu.uco.ucobet.generales.domain.city.rules;

import co.edu.uco.ucobet.generales.domain.DomainRule;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface CityIdDoesExistRule extends DomainRule<UUID> {
}
