package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;

import java.io.Serial;

public final class CityIdDoesntExistException extends RuleUcobetException {

    @Serial
    private static final long serialVersionUID = 1L;

    private CityIdDoesntExistException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CityIdDoesntExistException create() {
        return new CityIdDoesntExistException(
                MessageCatalogStrategy.getMessageContent(MessageCode.MCIT0000)
        );
    }
}
