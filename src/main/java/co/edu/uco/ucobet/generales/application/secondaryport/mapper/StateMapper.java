package co.edu.uco.ucobet.generales.application.secondaryport.mapper;

import co.edu.uco.ucobet.generales.application.secondaryport.entity.CountryEntity;
import co.edu.uco.ucobet.generales.application.secondaryport.entity.StateEntity;
import co.edu.uco.ucobet.generales.domain.country.CountryDomain;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

import java.util.ArrayList;
import java.util.List;

public final class StateMapper {

    public static StateDomain map(final StateEntity data) {
        return StateDomain.create(
                data.getId(),
                data.getName(),
                CountryDomain.create(data.getCountry().getId())
        );
    }

    public static StateEntity map(final StateDomain data) {
        return StateEntity.create(
                data.getId(),
                data.getName(),
                CountryEntity.create(data.getCountry().getId())
        );
    }

    public static List<StateDomain> map(List<StateEntity> data) {
        List<StateDomain> states = new ArrayList<>();
        for (StateEntity entity : data) {
            states.add(map(entity));
        }
        return states;
    }
}
