package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.messageCatalog;

import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.messages.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscutting.messages.enums.MessageCode;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.cache.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageCache {

    private static MessageCache instance;

    private final CacheService cacheService;

    @Autowired
    private MessageCache(final CacheService cacheService) {
        this.cacheService = cacheService;
        instance = this;
    }

    public static MessageCache getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Message catalog failed to start");
        }
        return instance;
    }

    public String getUserMessage(String code) {
        return ObjectHelper.getDefault(cacheService.getExceptionMessage(code), "fatal error");
    }

    public String getTechnicalMessage(String code) {
        return ObjectHelper.getDefault(cacheService.getExceptionMessage(code), "fatal error");
    }

}
