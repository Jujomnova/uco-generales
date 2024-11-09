package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;
import co.edu.uco.ucobet.generales.domain.city.rules.impl.CityNameForStateDoesNotExistImpl;

import java.io.Serial;

public final class CityNameForStateDoesntExistException extends RuleUcobetException {

    @Serial
    private static final long serialVersionUID = 1L;

    private CityNameForStateDoesntExistException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CityNameForStateDoesntExistException create() {
        return new CityNameForStateDoesntExistException(
                MessageCatalogStrategy.getMessageContent(MessageCode.MCIT0006)
        );
    }
}
