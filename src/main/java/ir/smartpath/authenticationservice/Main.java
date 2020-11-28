package ir.smartpath.authenticationservice;


import java.math.BigDecimal;
import java.math.BigInteger;


class Main
{
    /** Using exact integer arithmetic, print N_Terms ascending
     members of the Fibonacci sequence, prefixed by their term numbers,
     and followed by the ratio of successive terms, to demonstrate the
     1.618...^n growth (the ratio approaches the golden ratio, (1 +
     sqrt(5))/2 = 1.6180339887498949, and reaches it (to 64-bit machine
     precision) at 41 terms: the fourth item on each line is the
     difference from the golden ratio).

     Java's BigDecimal package, which is intended for simple
     high-precision currency calculations, does not provide elementary
     functions, such as sqrt(), so we supply a 100D-string
     representation for the golden_ratio. */

    private static final int Fractional_Digits = 50; //
    private static final int N_Terms = 300000; //



    static final BigDecimal golden_ratio = new BigDecimal("1.618033988749894848204586834365638117720309179805762862135448622705260462818902449707207204189391138");

    public static void main(String[] args)
    {

        System.out.println(f(1200000));
    }

    private static final BigInteger[][] MATRIX =
            {{BigInteger.ONE, BigInteger.ONE},
                    {BigInteger.ONE, BigInteger.ZERO}};

    public static BigInteger f(int n) {
        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;
        return power(MATRIX, n - 1)[0][0];
    }

    private static BigInteger[][] power(BigInteger[][] m, int power) {
        if (power == 1) return m;
        BigInteger[][] sub = power(m, power / 2);
        if (power % 2 == 0) {
            return multiply(sub, sub);
        } else {
            return multiply(multiply(sub, sub), m);
        }
    }

    private static BigInteger[][] multiply(BigInteger[][] m1, BigInteger[][] m2) {
        return new BigInteger[][]{
                {m1[0][0].multiply(m2[0][0]).add(m1[0][1].multiply(m2[1][0])),
                        m1[0][0].multiply(m2[0][1]).add(m1[0][1].multiply(m2[1][1]))},
                {m1[1][0].multiply(m2[0][0]).add(m1[1][1].multiply(m2[1][0])),
                        m1[1][0].multiply(m2[0][1]).add(m1[1][1].multiply(m2[1][1]))}
        };
    }
}
