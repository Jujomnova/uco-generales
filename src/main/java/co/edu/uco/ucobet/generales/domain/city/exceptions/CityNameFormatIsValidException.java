package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;

import java.io.Serial;

public final class CityNameFormatIsValidException extends RuleUcobetException {

    @Serial
    private static final long serialVersionUID = 1L;

    public CityNameFormatIsValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CityNameFormatIsValidException create(final String userMessage) {
        return new CityNameFormatIsValidException(
                TextHelper.getDefault(userMessage, MessageCatalogStrategy.getMessage(MessageCode.MCIT0005).getContent()));
    }
}
