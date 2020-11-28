package ir.smartpath.authenticationservice.fibo;

import java.math.BigInteger;
import java.util.concurrent.Callable;

public class FiboTask implements Callable<BigInteger> {

    private int term;

    public FiboTask(int term) {
        this.term = term;
    }

    private BigInteger[][] matrix =
            {{BigInteger.ONE, BigInteger.ONE},
                    {BigInteger.ONE, BigInteger.ZERO}};

    private BigInteger getFiboTerm(int term) {
        if (term == 0) return BigInteger.ZERO;
        if (term == 1) return BigInteger.ONE;
        return power(matrix, term - 1)[0][0];
    }

    private BigInteger[][] power(BigInteger[][] m, int power) {
        if (power == 1) return m;
        BigInteger[][] sub = power(m, power / 2);
        if (power % 2 == 0) {
            return multiply(sub, sub);
        } else {
            return multiply(multiply(sub, sub), m);
        }
    }

    private BigInteger[][] multiply(BigInteger[][] m1, BigInteger[][] m2) {
        return new BigInteger[][]{
                {m1[0][0].multiply(m2[0][0]).add(m1[0][1].multiply(m2[1][0])),
                        m1[0][0].multiply(m2[0][1]).add(m1[0][1].multiply(m2[1][1]))},
                {m1[1][0].multiply(m2[0][0]).add(m1[1][1].multiply(m2[1][0])),
                        m1[1][0].multiply(m2[0][1]).add(m1[1][1].multiply(m2[1][1]))}
        };
    }

    @Override
    public BigInteger call() throws Exception {
        return getFiboTerm(term);
    }
}
