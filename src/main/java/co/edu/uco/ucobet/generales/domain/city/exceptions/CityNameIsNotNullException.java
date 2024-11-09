package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;

import java.io.Serial;

public final class CityNameIsNotNullException extends RuleUcobetException {

    @Serial
    private static final long serialVersionUID = 1L;

    public CityNameIsNotNullException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CityNameIsNotNullException create() {
        return new CityNameIsNotNullException(
                MessageCatalogStrategy.getMessageContent(MessageCode.MCIT0007)
        );
    }
}
