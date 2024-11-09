package co.edu.uco.ucobet.generales.domain.country.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;

import java.io.Serial;

public final class CountryNameFormatIsValidException extends RuleUcobetException {

    @Serial
    private static final long serialVersionUID = 1L;

    public CountryNameFormatIsValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CountryNameFormatIsValidException create() {
        return new CountryNameFormatIsValidException(
                MessageCatalogStrategy.getMessageContent(MessageCode.MCOU0005)
        );
    }
}
