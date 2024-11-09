package co.edu.uco.ucobet.generales.application.primaryport.mapper.country;

import co.edu.uco.ucobet.generales.application.secondaryport.entity.CountryEntity;
import co.edu.uco.ucobet.generales.domain.country.CountryDomain;

public final class CountryDomainToEntityMapper {

    private CountryDomainToEntityMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static CountryEntity map(CountryDomain domain){
        return CountryEntity.create(
            domain.getId(),
            domain.getName()
        );
    }
}
