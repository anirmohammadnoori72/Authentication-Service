package ir.smartpath.authenticationservice.security.services;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TokenStore {

    LoadingCache<String, Long> tokens = Caffeine.newBuilder()
            .expireAfterAccess(24, TimeUnit.HOURS)
            .build(key -> null);


    public void store(String token) {
            tokens.put(token,System.currentTimeMillis());
    }

    public boolean hasToken(String token) {
        return tokens.get(token) != null ;
    }
}
