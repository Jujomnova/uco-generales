package co.edu.uco.ucobet.generales.application.primaryport.interactor.state;

import co.edu.uco.ucobet.generales.application.primaryport.dto.GetStateDTO;
import co.edu.uco.ucobet.generales.application.primaryport.interactor.InteractorWithoutParameters;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface GetStatesInteractor extends InteractorWithoutParameters<List<GetStateDTO>> {
}
