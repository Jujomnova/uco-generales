package co.edu.uco.ucobet.generales.domain.country.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;

import java.io.Serial;

public final class CountryIdIsNotNullException extends RuleUcobetException {

    @Serial
    private static final long serialVersionUID = 1L;

    private CountryIdIsNotNullException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CountryIdIsNotNullException create() {
        return new CountryIdIsNotNullException(
                MessageCatalogStrategy.getMessageContent(MessageCode.MCOU0002)
        );
    }
}
