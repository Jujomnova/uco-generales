package co.edu.uco.ucobet.generales.application.secondaryport.mapper;

import co.edu.uco.ucobet.generales.application.primaryport.mapper.state.StateDomainToDTOMapper;
import co.edu.uco.ucobet.generales.application.secondaryport.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryport.entity.StateEntity;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;


public final class CityDomainToEntityMapper {

    private CityDomainToEntityMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static CityEntity map(final CityDomain data) {
        return CityEntity.create(
            data.getId(),
            data.getName(),
                StateEntity.create(data.getState().getId())
        );
    }
}
