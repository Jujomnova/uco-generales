package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;

import java.io.Serial;

public final class StateDoesExistException extends RuleUcobetException {

    @Serial
    private static final long serialVersionUID = 1L;

    public StateDoesExistException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static StateDoesExistException create() {
        return new StateDoesExistException(
                MessageCatalogStrategy.getMessageContent(MessageCode.MSTA0001)
        );
    }
}
