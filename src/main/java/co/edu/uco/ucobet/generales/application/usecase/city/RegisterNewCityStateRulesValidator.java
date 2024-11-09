package co.edu.uco.ucobet.generales.application.usecase.city;

import co.edu.uco.ucobet.generales.application.usecase.RulesValidator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Qualifier("registerNewCityStateRulesValidator")
public interface RegisterNewCityStateRulesValidator extends RulesValidator<UUID> {
}
