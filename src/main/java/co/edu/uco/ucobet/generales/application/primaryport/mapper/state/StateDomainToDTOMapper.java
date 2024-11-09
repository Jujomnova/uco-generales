package co.edu.uco.ucobet.generales.application.primaryport.mapper.state;

import co.edu.uco.ucobet.generales.application.primaryport.dto.GetStateDTO;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

import java.util.ArrayList;
import java.util.List;

public final class StateDomainToDTOMapper {

    private StateDomainToDTOMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static GetStateDTO map(final StateDomain data) {
        return GetStateDTO.create(
                data.getId(),
                data.getName(),
                data.getCountry().getId()
        );
    }

    public static List<GetStateDTO> map(final List<StateDomain> domain){
        List<GetStateDTO> list = new ArrayList<>();
        for (StateDomain state : domain) {
            list.add(map(state));
        }
        return list;
    }
}
