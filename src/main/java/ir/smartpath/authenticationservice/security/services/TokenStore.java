package ir.smartpath.authenticationservice.security.services;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TokenStore {

    LoadingCache<String, Boolean> tokens = Caffeine.newBuilder()
            .expireAfterAccess(24, TimeUnit.HOURS)
            .build(key -> false);


    public void store(String token) {
        tokens.put(token, true);
    }

    public boolean hasToken(String token) {
        return tokens.get(token) != null && tokens.get(token);
    }

    public void expireToken(String token) {
        tokens.put(token, false);
    }
}
