package ir.smartpath.authenticationservice.fibo;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import ir.smartpath.authenticationservice.configuration.Config;
import org.springframework.stereotype.Service;


import java.math.BigInteger;
import java.util.concurrent.*;

@Service
public class FiboSequenceBuilder implements IFiboSequenceBuilder {

    private ExecutorService executors = Executors.newFixedThreadPool(10);

    private Config config = Config.getInstance();

    LoadingCache<Integer, BigInteger> fibos = Caffeine.newBuilder()
            .maximumSize(10_000)
            .expireAfterAccess(10, TimeUnit.MINUTES)
            .build(key -> calc(key));


    @Override
    public BigInteger get(int term) throws Exception {

        if (config.isEnableFiboCache()) return fibos.get(term);

        return calc(term);
    }

    public BigInteger calc(int term) throws InterruptedException, ExecutionException, TimeoutException {

        Callable<BigInteger> callable = new FiboTask(term);
        Future<BigInteger> result = executors.submit(callable);

        try {
            return result.get(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            throw e;
        }
    }
}
