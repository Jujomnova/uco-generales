package co.edu.uco.ucobet.generales.crosscutting.messages.catalog;

import co.edu.uco.ucobet.generales.crosscutting.exception.CrosscuttingUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.messages.Message;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalog;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.messageCatalog.MessageCache;

import java.util.HashMap;
import java.util.Map;

public class MessageCatalogBase implements MessageCatalog {

    private final Map<String, Message> messages = new HashMap<>();

    private final MessageCache messageCache = MessageCache.getInstance();

    public final void initialize()
    {
        messages.clear();

        messages.put(MessageCode.M0000.getFullIdentifier(),
                new Message(MessageCode.M0000, MessageCache.getInstance().getUserMessage(MessageCode.M0000.getId())));
        messages.put(MessageCode.M0001.getFullIdentifier(),
                new Message(MessageCode.M0001, MessageCache.getInstance().getUserMessage(MessageCode.M0001.getId())));
        messages.put(MessageCode.M0002.getFullIdentifier(),
                new Message(MessageCode.M0002, MessageCache.getInstance().getUserMessage(MessageCode.M0002.getId())));
        messages.put(MessageCode.M0003.getFullIdentifier(),
                new Message(MessageCode.M0003, MessageCache.getInstance().getUserMessage(MessageCode.M0003.getId())));
        messages.put(MessageCode.M0004.getFullIdentifier(),
                new Message(MessageCode.M0004, MessageCache.getInstance().getUserMessage(MessageCode.M0004.getId())));
        messages.put(MessageCode.M0005.getFullIdentifier(),
                new Message(MessageCode.M0005, MessageCache.getInstance().getUserMessage(MessageCode.M0005.getId())));
        messages.put(MessageCode.M0006.getFullIdentifier(),
                new Message(MessageCode.M0006, MessageCache.getInstance().getUserMessage(MessageCode.M0006.getId())));
        messages.put(MessageCode.M0007.getFullIdentifier(),
                new Message(MessageCode.M0007, MessageCache.getInstance().getUserMessage(MessageCode.M0007.getId())));
        messages.put(MessageCode.M0008.getFullIdentifier(),
                new Message(MessageCode.M0008, MessageCache.getInstance().getUserMessage(MessageCode.M0008.getId())));
        messages.put(MessageCode.M0009.getFullIdentifier(),
                new Message(MessageCode.M0009, MessageCache.getInstance().getUserMessage(MessageCode.M0009.getId())));
        messages.put(MessageCode.M0010.getFullIdentifier(),
                new Message(MessageCode.M0010, MessageCache.getInstance().getUserMessage(MessageCode.M0010.getId())));
        messages.put(MessageCode.M0011.getFullIdentifier(),
                new Message(MessageCode.M0011, MessageCache.getInstance().getUserMessage(MessageCode.M0011.getId())));
    }

    @Override
    public String getMessageContent(final MessageCode code, final String... params) {

        return TextHelper.replaceExceptionMessageParams(getMessage(code, params).getContent(), params);
    }

    @Override
    public Message getMessage(MessageCode code, String... params) {

        if (ObjectHelper.isNull(code))
        {
            throw CrosscuttingUcobetException.create(
                    getMessageContent(MessageCode.M0000),
                    getMessageContent(MessageCode.M0001)
            );
        }

        if (!code.isBase())
        {
            throw CrosscuttingUcobetException.create(
                    getMessageContent(MessageCode.M0000),
                    getMessageContent(MessageCode.M0002)
            );
        }

        if (!messages.containsKey(code.getFullIdentifier()))
        {
            throw CrosscuttingUcobetException.create(
                    getMessageContent(MessageCode.M0000),
                    getMessageContent(MessageCode.M0003)
            );
        }

        return messages.get(code.getFullIdentifier());
    }
}
