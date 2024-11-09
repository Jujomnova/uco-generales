package co.edu.uco.ucobet.generales.application.primaryport.mapper.city;

import co.edu.uco.ucobet.generales.application.primaryport.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.country.CountryDomain;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

public final class RegisterCityDtoToDomainMapper {
    private RegisterCityDtoToDomainMapper() {}

    public static CityDomain map(RegisterNewCityDTO dto) {
        return CityDomain.create(
                UUIDHelper.getDefault(),
                dto.getName(),
                StateDomain.create(
                        dto.getStateId(),
                        TextHelper.EMPTY,
                        CountryDomain.create()
                )
        );
    }
}
