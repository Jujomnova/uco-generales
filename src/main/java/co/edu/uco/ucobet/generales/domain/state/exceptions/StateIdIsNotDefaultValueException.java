package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;

import java.io.Serial;

public final class StateIdIsNotDefaultValueException extends RuleUcobetException {

    @Serial
    private static final long serialVersionUID = 1L;

    public StateIdIsNotDefaultValueException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static StateIdIsNotDefaultValueException create() {
        return new StateIdIsNotDefaultValueException(
                MessageCatalogStrategy.getMessageContent(MessageCode.MSTA0008)
        );
    }
}
