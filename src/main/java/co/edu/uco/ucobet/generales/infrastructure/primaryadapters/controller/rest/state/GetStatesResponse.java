package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.state;

import co.edu.uco.ucobet.generales.application.primaryport.dto.GetStateDTO;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.Response;

import java.util.ArrayList;
import java.util.List;

public class GetStatesResponse extends Response<List<GetStateDTO>> {

    public GetStatesResponse() {
        setMessages(new ArrayList<>());
        setData(new ArrayList<>());
    }
}
