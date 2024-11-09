package co.edu.uco.ucobet.generales.crosscutting.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.enums.Layer;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;

import java.io.Serial;

public class RuleUcobetException extends UcobetException {

    @Serial
    private static final long serialVersionUID = 1L;

    public RuleUcobetException(final String userMessage, final String technicalMessage, final Exception rootException) {
        super(userMessage, technicalMessage, rootException, Layer.RULE);
    }

    public static RuleUcobetException create(final String userMessage, final String technicalMessage, final Exception rootException) {
        return new RuleUcobetException(userMessage, technicalMessage, rootException);
    }

    public static RuleUcobetException create(final String userMessage, final String technicalMessage) {
        return new RuleUcobetException(userMessage, technicalMessage, new Exception());
    }

    public static RuleUcobetException create(final String userMessage) {
        return new RuleUcobetException(userMessage, userMessage, new Exception());
    }

    public static RuleUcobetException create() {
        return new RuleUcobetException(
                MessageCatalogStrategy.getMessageContent(MessageCode.M0005),
                MessageCatalogStrategy.getMessageContent(MessageCode.M0005),
                new Exception());
    }
}
