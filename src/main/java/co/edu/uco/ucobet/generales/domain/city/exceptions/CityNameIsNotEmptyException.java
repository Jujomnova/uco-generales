package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;

import java.io.Serial;

public final class CityNameIsNotEmptyException extends RuleUcobetException {

    @Serial
    private static final long serialVersionUID = 1L;

    public CityNameIsNotEmptyException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CityNameIsNotEmptyException create() {
        return new CityNameIsNotEmptyException(
                MessageCatalogStrategy.getMessageContent(MessageCode.MCIT0013)
        );
    }
}
