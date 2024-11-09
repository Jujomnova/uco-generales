package co.edu.uco.ucobet.generales.crosscutting.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.enums.Layer;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;

import java.io.Serial;

public class RepositoryUcobetException extends UcobetException {

    @Serial
    private static final long serialVersionUID = 1L;

    private RepositoryUcobetException(final String userMessage, final String technicalMessage, final Exception rootException) {
        super(userMessage, technicalMessage, rootException, Layer.REPOSITORY);
    }

    public static RepositoryUcobetException create(final String userMessage, final String technicalMessage, final Exception rootException) {
        return new RepositoryUcobetException(userMessage, technicalMessage, rootException);
    }

    public static RepositoryUcobetException create(final String userMessage, final String technicalMessage) {
        return new RepositoryUcobetException(userMessage, technicalMessage, new Exception());
    }

    public static RepositoryUcobetException create(final String userMessage) {
        return new RepositoryUcobetException(userMessage, userMessage, new Exception());
    }

    public static RepositoryUcobetException create() {
        return new RepositoryUcobetException(
                MessageCatalogStrategy.getMessageContent(MessageCode.M0006),
                MessageCatalogStrategy.getMessageContent(MessageCode.M0006),
                new Exception());
    }
}
