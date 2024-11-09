package co.edu.uco.ucobet.generales.domain.country.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;

import java.io.Serial;

public final class CountryIdDoesntExistException extends RuleUcobetException {

    @Serial
    private static final long serialVersionUID = 1L;

    private CountryIdDoesntExistException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CountryIdDoesntExistException create() {
        return new CountryIdDoesntExistException(
                MessageCatalogStrategy.getMessageContent(MessageCode.MCOU0001)
        );
    }
}
