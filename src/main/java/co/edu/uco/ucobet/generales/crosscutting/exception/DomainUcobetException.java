package co.edu.uco.ucobet.generales.crosscutting.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.enums.Layer;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;

import java.io.Serial;

public class DomainUcobetException extends UcobetException {
    @Serial
    private static final long serialVersionUID = 1L;

    private DomainUcobetException(final String userMessage, final String technicalMessage, final Exception rootException) {
        super(userMessage, technicalMessage, rootException, Layer.DOMAIN);
    }

    public static DomainUcobetException create(final String userMessage, final String technicalMessage, final Exception rootException) {
        return new DomainUcobetException(userMessage, technicalMessage, rootException);
    }

    public static DomainUcobetException create(final String userMessage, final String technicalMessage) {
        return new DomainUcobetException(userMessage, technicalMessage, new Exception());
    }

    public static DomainUcobetException create(final String userMessage) {
        return new DomainUcobetException(userMessage, userMessage, new Exception());
    }

    public static DomainUcobetException create() {
        return new DomainUcobetException(
                MessageCatalogStrategy.getMessageContent(MessageCode.M0009),
                MessageCatalogStrategy.getMessageContent(MessageCode.M0009),
                new Exception());
    }
}
