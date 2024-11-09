package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.state;

import co.edu.uco.ucobet.generales.application.primaryport.interactor.state.impl.GetStatesInteractorImpl;
import co.edu.uco.ucobet.generales.crosscutting.exception.UcobetException;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/general/api/v1/states")
public class GetStatesController {

    private final GetStatesInteractorImpl getStatesInteractor;

    public GetStatesController(final GetStatesInteractorImpl getStatesInteractor) {
        this.getStatesInteractor = getStatesInteractor;
    }

    @GetMapping
    public ResponseEntity<GetStatesResponse> getStates() {
        HttpStatus httpStatus = HttpStatus.ACCEPTED;
        GetStatesResponse response = new GetStatesResponse();

        try {
            response.getData().add(getStatesInteractor.execute());
            response.getMessages().add(MessageCatalogStrategy.getMessageContent(MessageCode.MSTA0010));
        } catch (UcobetException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.getMessages().add(exception.getUserMessage());
        } catch (Exception exception) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            response.getMessages().add(exception.getMessage());
        }

        return new ResponseEntity<>(response, httpStatus);
    }
}
