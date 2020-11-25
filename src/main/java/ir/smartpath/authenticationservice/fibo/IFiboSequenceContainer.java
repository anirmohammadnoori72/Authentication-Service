package ir.smartpath.authenticationservice.fibo;

import ir.smartpath.authenticationservice.exeption.OutOfRangeFiboTermException;

interface IFiboSequenceContainer {
    String get(int term) throws OutOfRangeFiboTermException;
}
