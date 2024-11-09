package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;

import java.io.Serial;

public final class CityIdIsNotNullException extends RuleUcobetException {

    @Serial
    private static final long serialVersionUID = 1L;

    private CityIdIsNotNullException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CityIdIsNotNullException create() {
        return new CityIdIsNotNullException(
                MessageCatalogStrategy.getMessageContent(MessageCode.MCIT0002)
        );
    }
}
