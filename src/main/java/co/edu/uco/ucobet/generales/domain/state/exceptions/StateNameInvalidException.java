package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;

import java.io.Serial;

public final class StateNameInvalidException extends RuleUcobetException {

    @Serial
    private static final long serialVersionUID = 1L;

    public StateNameInvalidException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static StateNameInvalidException create() {
        return new StateNameInvalidException(
                MessageCatalogStrategy.getMessageContent(MessageCode.MSTA0004)
        );
    }
}
