package co.edu.uco.ucobet.generales.crosscutting.messages;

import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;

public interface MessageCatalog {

    void initialize();
    String getMessageContent(final MessageCode code, String... params);
    Message getMessage(final MessageCode code, String... params);
}
