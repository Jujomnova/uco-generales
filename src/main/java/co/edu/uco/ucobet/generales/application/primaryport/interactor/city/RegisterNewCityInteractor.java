package co.edu.uco.ucobet.generales.application.primaryport.interactor.city;

import co.edu.uco.ucobet.generales.application.primaryport.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.application.primaryport.interactor.InteractorWithoutReturn;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface RegisterNewCityInteractor extends InteractorWithoutReturn<RegisterNewCityDTO> {
}
