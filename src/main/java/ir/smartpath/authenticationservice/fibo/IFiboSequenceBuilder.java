package ir.smartpath.authenticationservice.fibo;


import java.math.BigInteger;
import java.util.concurrent.TimeoutException;

interface IFiboSequenceBuilder {
    BigInteger get(int term) throws Exception;
}
