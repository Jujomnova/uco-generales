package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.city;

import co.edu.uco.ucobet.generales.application.primaryport.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.application.primaryport.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.crosscutting.exception.UcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/general/api/v1/cities")
public class RegisterNewCityController {

    private final RegisterNewCityInteractor registerNewCityInteractor;

    @Autowired
    public RegisterNewCityController(RegisterNewCityInteractor registerNewCityInteractor) {
        this.registerNewCityInteractor = registerNewCityInteractor;
    }

    @PostMapping
    public ResponseEntity<RegisterNewCityResponse> execute(@RequestBody RegisterNewCityDTO dto) {
        HttpStatus httpStatus = HttpStatus.ACCEPTED;
        RegisterNewCityResponse response = new RegisterNewCityResponse();

        try {
            registerNewCityInteractor.execute(dto);
            response.getMessages().add(MessageCatalogStrategy.getMessageContent(MessageCode.MCIT0009));
        } catch (UcobetException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.getMessages().add(exception.getUserMessage());
        } catch (Exception exception) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            response.getMessages().add(exception.getMessage());
        }

        return new ResponseEntity<>(response, httpStatus);
    }

    @GetMapping
    public RegisterNewCityDTO executeDummy() {
        return RegisterNewCityDTO.create(UUIDHelper.generate(), "Rionegro");
    }
}
