package ir.smartpath.authenticationservice.fibo;

import com.github.benmanes.caffeine.cache.Cache;
import ir.smartpath.authenticationservice.exeption.OutOfRangeFiboTermException;

import java.util.HashMap;

public class FiboSequenceContainer implements IFiboSequenceContainer {
    private HashMap<Integer, String> fiboSequence = new HashMap<>();

    private Cache<Integer, String> fiboSequenceCache;

    private int maxTermSupport;

    public FiboSequenceContainer() {
        evalMxTerm();
    }

    @Override
    public String get(int term) throws OutOfRangeFiboTermException {
        if (term > maxTermSupport)
            throw new OutOfRangeFiboTermException(new StringBuilder("out of range query, max support term is : ")
                    .append(maxTermSupport)
                    .append("your query is : ")
                    .append(term)
                    .toString());
        return fiboSequence.get(term);
    }

    private void evalMxTerm() {
        maxTermSupport = Integer.MAX_VALUE - 1;
    }
}
