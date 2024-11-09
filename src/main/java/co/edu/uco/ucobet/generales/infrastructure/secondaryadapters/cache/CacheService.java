package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.cache;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

    private final RedisTemplate<String, String> redisTemplate;

    public CacheService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public String getExceptionMessage(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
