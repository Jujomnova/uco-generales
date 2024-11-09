package co.edu.uco.ucobet.generales.crosscutting.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.enums.Layer;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;

import java.io.Serial;

public class InfrastructureUcobetException extends UcobetException {
    @Serial
    private static final long serialVersionUID = 1L;

    private InfrastructureUcobetException(final String userMessage, final String technicalMessage, final Exception rootException) {
        super(userMessage, technicalMessage, rootException, Layer.INFRASTRUCTURE);
    }

    public static InfrastructureUcobetException create(final String userMessage, final String technicalMessage, final Exception rootException) {
        return new InfrastructureUcobetException(userMessage, technicalMessage, rootException);
    }

    public static InfrastructureUcobetException create(final String userMessage, final String technicalMessage) {
        return new InfrastructureUcobetException(userMessage, technicalMessage, new Exception());
    }

    public static InfrastructureUcobetException create(final String userMessage) {
        return new InfrastructureUcobetException(userMessage, userMessage, new Exception());
    }

    public static InfrastructureUcobetException create() {
        return new InfrastructureUcobetException(
                MessageCatalogStrategy.getMessageContent(MessageCode.M0008),
                MessageCatalogStrategy.getMessageContent(MessageCode.M0008),
                new Exception());
    }
}
