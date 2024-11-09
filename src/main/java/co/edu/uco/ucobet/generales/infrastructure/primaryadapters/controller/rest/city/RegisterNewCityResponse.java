package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.city;

import co.edu.uco.ucobet.generales.application.primaryport.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.Response;

import java.util.ArrayList;

public class RegisterNewCityResponse extends Response<RegisterNewCityDTO> {

    public RegisterNewCityResponse() {
        setMessages(new ArrayList<>());
        setData(new ArrayList<>());
    }
}
