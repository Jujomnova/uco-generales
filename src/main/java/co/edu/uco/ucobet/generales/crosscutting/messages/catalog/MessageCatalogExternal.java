package co.edu.uco.ucobet.generales.crosscutting.messages.catalog;

import co.edu.uco.ucobet.generales.crosscutting.exception.CrosscuttingUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.messages.Message;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalog;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.messagecatalog.MessageCache;

import java.util.HashMap;
import java.util.Map;

public class MessageCatalogExternal implements MessageCatalog {

    private final Map<String, Message> messages = new HashMap<>();

    public final void initialize()
    {
        messages.clear();
        messages.put(MessageCode.MCOU0000.getFullIdentifier(),
                new Message(MessageCode.MCOU0000, MessageCache.getUserMessage(MessageCode.MCOU0000.getId())));
        messages.put(MessageCode.MCOU0001.getFullIdentifier(),
                new Message(MessageCode.MCOU0001, MessageCache.getUserMessage(MessageCode.MCOU0001.getId())));
        messages.put(MessageCode.MCOU0002.getFullIdentifier(),
                new Message(MessageCode.MCOU0002, MessageCache.getUserMessage(MessageCode.MCOU0002.getId())));
        messages.put(MessageCode.MCOU0003.getFullIdentifier(),
                new Message(MessageCode.MCOU0003, MessageCache.getUserMessage(MessageCode.MCOU0003.getId())));
        messages.put(MessageCode.MCOU0004.getFullIdentifier(),
                new Message(MessageCode.MCOU0004, MessageCache.getUserMessage(MessageCode.MCOU0004.getId())));
        messages.put(MessageCode.MCOU0005.getFullIdentifier(),
                new Message(MessageCode.MCOU0005, MessageCache.getUserMessage(MessageCode.MCOU0005.getId())));
        messages.put(MessageCode.MCOU0006.getFullIdentifier(),
                new Message(MessageCode.MCOU0006, MessageCache.getUserMessage(MessageCode.MCOU0006.getId())));

        messages.put(MessageCode.MSTA0000.getFullIdentifier(),
                new Message(MessageCode.MSTA0000, MessageCache.getUserMessage(MessageCode.MSTA0000.getId())));
        messages.put(MessageCode.MSTA0001.getFullIdentifier(),
                new Message(MessageCode.MSTA0001, MessageCache.getUserMessage(MessageCode.MSTA0001.getId())));
        messages.put(MessageCode.MSTA0002.getFullIdentifier(),
                new Message(MessageCode.MSTA0002, MessageCache.getUserMessage(MessageCode.MSTA0002.getId())));
        messages.put(MessageCode.MSTA0003.getFullIdentifier(),
                new Message(MessageCode.MSTA0003, MessageCache.getUserMessage(MessageCode.MSTA0003.getId())));
        messages.put(MessageCode.MSTA0004.getFullIdentifier(),
                new Message(MessageCode.MSTA0004, MessageCache.getUserMessage(MessageCode.MSTA0004.getId())));
        messages.put(MessageCode.MSTA0005.getFullIdentifier(),
                new Message(MessageCode.MSTA0005, MessageCache.getUserMessage(MessageCode.MSTA0005.getId())));
        messages.put(MessageCode.MSTA0006.getFullIdentifier(),
                new Message(MessageCode.MSTA0006, MessageCache.getUserMessage(MessageCode.MSTA0006.getId())));
        messages.put(MessageCode.MSTA0007.getFullIdentifier(),
                new Message(MessageCode.MSTA0007, MessageCache.getUserMessage(MessageCode.MSTA0007.getId())));
        messages.put(MessageCode.MSTA0008.getFullIdentifier(),
                new Message(MessageCode.MSTA0008, MessageCache.getUserMessage(MessageCode.MSTA0008.getId())));
        messages.put(MessageCode.MSTA0009.getFullIdentifier(),
                new Message(MessageCode.MSTA0009, MessageCache.getUserMessage(MessageCode.MSTA0009.getId())));
        messages.put(MessageCode.MSTA0010.getFullIdentifier(),
                new Message(MessageCode.MSTA0010, MessageCache.getUserMessage(MessageCode.MSTA0010.getId())));
        messages.put(MessageCode.MSTA0011.getFullIdentifier(),
                new Message(MessageCode.MSTA0011, MessageCache.getUserMessage(MessageCode.MSTA0011.getId())));

        messages.put(MessageCode.MCIT0000.getFullIdentifier(),
                new Message(MessageCode.MCIT0000, MessageCache.getUserMessage(MessageCode.MCIT0000.getId())));
        messages.put(MessageCode.MCIT0001.getFullIdentifier(),
                new Message(MessageCode.MCIT0001, MessageCache.getUserMessage(MessageCode.MCIT0001.getId())));
        messages.put(MessageCode.MCIT0002.getFullIdentifier(),
                new Message(MessageCode.MCIT0002, MessageCache.getUserMessage(MessageCode.MCIT0002.getId())));
        messages.put(MessageCode.MCIT0003.getFullIdentifier(),
                new Message(MessageCode.MCIT0003, MessageCache.getUserMessage(MessageCode.MCIT0003.getId())));
        messages.put(MessageCode.MCIT0004.getFullIdentifier(),
                new Message(MessageCode.MCIT0004, MessageCache.getUserMessage(MessageCode.MCIT0004.getId())));
        messages.put(MessageCode.MCIT0005.getFullIdentifier(),
                new Message(MessageCode.MCIT0005, MessageCache.getUserMessage(MessageCode.MCIT0005.getId())));
        messages.put(MessageCode.MCIT0006.getFullIdentifier(),
                new Message(MessageCode.MCIT0006, MessageCache.getUserMessage(MessageCode.MCIT0006.getId())));
        messages.put(MessageCode.MCIT0007.getFullIdentifier(),
                new Message(MessageCode.MCIT0007, MessageCache.getUserMessage(MessageCode.MCIT0007.getId())));
        messages.put(MessageCode.MCIT0008.getFullIdentifier(),
                new Message(MessageCode.MCIT0008, MessageCache.getUserMessage(MessageCode.MCIT0008.getId())));
        messages.put(MessageCode.MCIT0009.getFullIdentifier(),
                new Message(MessageCode.MCIT0009, MessageCache.getUserMessage(MessageCode.MCIT0009.getId())));
        messages.put(MessageCode.MCIT0010.getFullIdentifier(),
                new Message(MessageCode.MCIT0010, MessageCache.getUserMessage(MessageCode.MCIT0010.getId())));
        messages.put(MessageCode.MCIT0011.getFullIdentifier(),
                new Message(MessageCode.MCIT0011, MessageCache.getUserMessage(MessageCode.MCIT0011.getId())));
        messages.put(MessageCode.MCIT0012.getFullIdentifier(),
                new Message(MessageCode.MCIT0012, MessageCache.getUserMessage(MessageCode.MCIT0012.getId())));
        messages.put(MessageCode.MCIT0013.getFullIdentifier(),
                new Message(MessageCode.MCIT0013, MessageCache.getUserMessage(MessageCode.MCIT0013.getId())));

        messages.put(MessageCode.MMAIL0000.getFullIdentifier(),
                new Message(MessageCode.MMAIL0000, MessageCache.getUserMessage(MessageCode.MMAIL0000.getId())));
        messages.put(MessageCode.MMAIL0001.getFullIdentifier(),
                new Message(MessageCode.MMAIL0001, MessageCache.getUserMessage(MessageCode.MMAIL0001.getId())));
        messages.put(MessageCode.MMAIL0002.getFullIdentifier(),
                new Message(MessageCode.MMAIL0002, MessageCache.getUserMessage(MessageCode.MMAIL0002.getId())));
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

        if (code.isBase())
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
