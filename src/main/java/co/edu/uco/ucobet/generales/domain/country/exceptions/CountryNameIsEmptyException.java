package co.edu.uco.ucobet.generales.domain.country.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;

import java.io.Serial;

public final class CountryNameIsEmptyException extends RuleUcobetException {

    @Serial
    private static final long serialVersionUID = 1L;

    public CountryNameIsEmptyException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CountryNameIsEmptyException create() {
        return new CountryNameIsEmptyException(
                MessageCatalogStrategy.getMessageContent(MessageCode.MCOU0003)
        );
    }
}
