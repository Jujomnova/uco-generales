package co.edu.uco.ucobet.generales.application.primaryport.interactor.state.impl;

import co.edu.uco.ucobet.generales.application.primaryport.dto.GetStateDTO;
import co.edu.uco.ucobet.generales.application.primaryport.interactor.InteractorWithoutParameters;
import co.edu.uco.ucobet.generales.application.primaryport.mapper.state.StateDomainToDTOMapper;
import co.edu.uco.ucobet.generales.application.usecase.state.GetStates;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetStatesInteractorImpl implements InteractorWithoutParameters<List<GetStateDTO>> {

    private final GetStates getStates;

    public GetStatesInteractorImpl(final GetStates getStates) {
        this.getStates = getStates;
    }

    @Override
    public List<GetStateDTO> execute() {
        List<StateDomain> result = getStates.execute();

        return StateDomainToDTOMapper.map(result);
    }
}
