package co.edu.uco.ucobet.generales.application.usecase.state;

import co.edu.uco.ucobet.generales.application.usecase.UseCaseWithReturnNoParams;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GetStates extends UseCaseWithReturnNoParams<List<StateDomain>> {
}
