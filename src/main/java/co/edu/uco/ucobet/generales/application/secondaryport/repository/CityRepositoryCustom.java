package co.edu.uco.ucobet.generales.application.secondaryport.repository;

import co.edu.uco.ucobet.generales.application.secondaryport.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryport.entity.StateEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepositoryCustom {

    List<CityEntity> findByNameAndState(String cityName, StateEntity stateId);
}
