package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;

import java.io.Serial;

public final class CityStateDoesntExistException extends RuleUcobetException {

    @Serial
    private static final long serialVersionUID = 1L;

    private CityStateDoesntExistException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CityStateDoesntExistException create() {
        return new CityStateDoesntExistException(
                MessageCatalogStrategy.getMessageContent(MessageCode.MSTA0000)
        );
    }
}
