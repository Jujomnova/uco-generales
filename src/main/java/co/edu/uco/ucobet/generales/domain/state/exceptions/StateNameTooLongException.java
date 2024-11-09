package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;

import java.io.Serial;

public final class StateNameTooLongException extends RuleUcobetException {

    @Serial
    private static final long serialVersionUID = 1L;

    public StateNameTooLongException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static StateNameTooLongException create() {
        return new StateNameTooLongException(
                MessageCatalogStrategy.getMessageContent(MessageCode.MSTA0007)
        );
    }
}
