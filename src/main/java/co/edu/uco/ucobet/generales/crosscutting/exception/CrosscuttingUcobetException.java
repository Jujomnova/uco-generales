package co.edu.uco.ucobet.generales.crosscutting.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.enums.Layer;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;

import java.io.Serial;

public class CrosscuttingUcobetException extends UcobetException {
    @Serial
    private static final long serialVersionUID = 1L;

    private CrosscuttingUcobetException(final String userMessage, final String technicalMessage, final Exception rootException) {
        super(userMessage, technicalMessage, rootException, Layer.GENERAL);
    }

    public static CrosscuttingUcobetException create(final String userMessage, final String technicalMessage, final Exception rootException) {
        return new CrosscuttingUcobetException(userMessage, technicalMessage, rootException);
    }

    public static CrosscuttingUcobetException create(final String userMessage, final String technicalMessage) {
        return new CrosscuttingUcobetException(userMessage, technicalMessage, null);
    }

    public static CrosscuttingUcobetException create(final String userMessage) {
        return new CrosscuttingUcobetException(userMessage, userMessage, new Exception());
    }

    public static CrosscuttingUcobetException create() {
        return new CrosscuttingUcobetException(
                MessageCatalogStrategy.getMessageContent(MessageCode.M0004),
                MessageCatalogStrategy.getMessageContent(MessageCode.M0004),
                new Exception());
    }
}
