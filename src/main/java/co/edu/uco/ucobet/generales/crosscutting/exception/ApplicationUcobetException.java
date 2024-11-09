package co.edu.uco.ucobet.generales.crosscutting.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.enums.Layer;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;

import java.io.Serial;

public class ApplicationUcobetException extends UcobetException {
    @Serial
    private static final long serialVersionUID = 1L;

    private ApplicationUcobetException(final String userMessage, final String technicalMessage, final Exception rootException) {
        super(userMessage, technicalMessage, rootException, Layer.APPLICATION);
    }

    public static ApplicationUcobetException create(final String userMessage, final String technicalMessage, final Exception rootException) {
        return new ApplicationUcobetException(userMessage, technicalMessage, rootException);
    }

    public static ApplicationUcobetException create(final String userMessage, final String technicalMessage) {
        return new ApplicationUcobetException(userMessage, technicalMessage, new Exception());
    }

    public static ApplicationUcobetException create(final String userMessage) {
        return new ApplicationUcobetException(userMessage, userMessage, new Exception());
    }

    public static ApplicationUcobetException create() {
        return new ApplicationUcobetException(
                MessageCatalogStrategy.getMessageContent(MessageCode.M0007),
                MessageCatalogStrategy.getMessageContent(MessageCode.M0007),
                new Exception());
    }
}
