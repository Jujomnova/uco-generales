package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;

import java.io.Serial;

public final class StateIdIsNotNullException extends RuleUcobetException {

    @Serial
    private static final long serialVersionUID = 1L;

    public StateIdIsNotNullException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static StateIdIsNotNullException create() {
        return new StateIdIsNotNullException(
                MessageCatalogStrategy.getMessageContent(MessageCode.MSTA0009)
        );
    }
}
