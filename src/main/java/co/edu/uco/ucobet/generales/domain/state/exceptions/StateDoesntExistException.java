package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;

import java.io.Serial;

public final class StateDoesntExistException extends RuleUcobetException {

    @Serial
    private static final long serialVersionUID = 1L;

    public StateDoesntExistException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static StateDoesntExistException create() {
        return new StateDoesntExistException(
                MessageCatalogStrategy.getMessageContent(MessageCode.MSTA0000)
        );
    }
}
