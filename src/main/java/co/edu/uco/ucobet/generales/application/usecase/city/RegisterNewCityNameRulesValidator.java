package co.edu.uco.ucobet.generales.application.usecase.city;

import co.edu.uco.ucobet.generales.application.usecase.RulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("RegisterNewCityNameRulesValidator")
public interface RegisterNewCityNameRulesValidator extends RulesValidator<CityDomain> {
}
