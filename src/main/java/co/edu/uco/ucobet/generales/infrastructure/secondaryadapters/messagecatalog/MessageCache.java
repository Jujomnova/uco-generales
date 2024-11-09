package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.messagecatalog;

import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.cache.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageCache {

    private static CacheService cacheService;

    @Autowired
    private MessageCache(final CacheService cacheService) {
        MessageCache.cacheService = cacheService;
    }

    public static String getUserMessage(String code) {
        return ObjectHelper.getDefault(cacheService.getExceptionMessage(code), "fatal error");
    }

    public static String getTechnicalMessage(String code) {
        return ObjectHelper.getDefault(cacheService.getExceptionMessage(code), "fatal error");
    }
}
