package co.edu.uco.ucobet.generales.domain.country.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;

import java.io.Serial;

public final class CountryIdIsValidException extends RuleUcobetException {

    @Serial
    private static final long serialVersionUID = 1L;

    public CountryIdIsValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CountryIdIsValidException create() {
        return new CountryIdIsValidException(
                MessageCatalogStrategy.getMessageContent(MessageCode.MCOU0004)
        );
    }
}
