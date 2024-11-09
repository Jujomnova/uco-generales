package co.edu.uco.ucobet.generales.application.usecase.state.impl;

import co.edu.uco.ucobet.generales.application.secondaryport.entity.StateEntity;
import co.edu.uco.ucobet.generales.application.secondaryport.mapper.StateMapper;
import co.edu.uco.ucobet.generales.application.secondaryport.repository.StateRepository;
import co.edu.uco.ucobet.generales.application.usecase.state.GetStates;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetStatesImpl implements GetStates {

    private final StateRepository stateRepository;

    public GetStatesImpl(final StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }
    @Override
    public List<StateDomain> execute() {
        List<StateEntity> result = stateRepository.findAll();

        return StateMapper.map(result);
    }
}
