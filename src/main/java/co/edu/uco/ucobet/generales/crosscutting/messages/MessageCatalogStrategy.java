package co.edu.uco.ucobet.generales.crosscutting.messages;

import co.edu.uco.ucobet.generales.crosscutting.exception.CrosscuttingUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.messages.catalog.MessageCatalogBase;
import co.edu.uco.ucobet.generales.crosscutting.messages.catalog.MessageCatalogExternal;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;

public class MessageCatalogStrategy {
    private static final MessageCatalog base = new MessageCatalogBase();
    private static final MessageCatalog external = new MessageCatalogExternal();

    static { initialize(); }

    private MessageCatalogStrategy() {super();}

    public static void initialize()
    {
        base.initialize();
        external.initialize();
    }

    private static MessageCatalog getStrat( final boolean isBase )
    {
        return isBase ? base : external;
    }

    public static Message getMessage(final MessageCode code, final String... params)
    {
        if (ObjectHelper.isNull(code))
        {
            throw CrosscuttingUcobetException.create();
        }

        return getStrat(code.isBase()).getMessage(code, params);
    }

    public static String getMessageContent(final MessageCode code, final String... params)
    {
        if (TextHelper.getCountMessageParameters(getMessage(code).getContent()) != params.length)
        {
            throw CrosscuttingUcobetException.create();
        }

        return TextHelper.replaceExceptionMessageParams(getMessage(code, params).getContent(), params);
    }
}
