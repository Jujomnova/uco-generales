package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.application.primaryport.mapper.state.StateDomainToDTOMapper;
import co.edu.uco.ucobet.generales.application.secondaryport.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryport.entity.StateEntity;
import co.edu.uco.ucobet.generales.application.secondaryport.mapper.CityDomainToEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryport.mapper.StateMapper;
import co.edu.uco.ucobet.generales.application.secondaryport.repository.CityRepository;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameForStateDoesntExistException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameForStateDoesntExistRule;
import org.springframework.stereotype.Service;

@Service
public final class CityNameForStateDoesNotExistImpl implements CityNameForStateDoesntExistRule {

    private final CityRepository cityRepository;

    public CityNameForStateDoesNotExistImpl(final CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void validate(CityDomain data) {

        var cityFilter = CityEntity.create(
                UUIDHelper.getDefault(),
                data.getName(),
                StateMapper.map(data.getState())
        );

        var result = cityRepository.findByNameAndState(cityFilter.getName(), cityFilter.getState());

        if (!result.isEmpty()){
            throw CityNameForStateDoesntExistException.create();
        }
    }
}
