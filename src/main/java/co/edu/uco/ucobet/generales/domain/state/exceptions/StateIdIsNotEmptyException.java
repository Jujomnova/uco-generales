package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;

import java.io.Serial;

public final class StateIdIsNotEmptyException extends RuleUcobetException {

    @Serial
    private static final long serialVersionUID = 1L;

    public StateIdIsNotEmptyException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static StateIdIsNotEmptyException create() {
        return new StateIdIsNotEmptyException(
                MessageCatalogStrategy.getMessageContent(MessageCode.MSTA0004)
        );
    }
}
