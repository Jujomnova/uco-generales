package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;

import java.io.Serial;

public final class StateNameEmptyException extends RuleUcobetException {

    @Serial
    private static final long serialVersionUID = 1L;

    public StateNameEmptyException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static StateNameEmptyException create() {
        return new StateNameEmptyException(
                MessageCatalogStrategy.getMessageContent(MessageCode.MSTA0003)
        );
    }
}
