package ir.smartpath.authenticationservice.exeption;

public class OutOfRangeFiboTermException extends Exception {

    public OutOfRangeFiboTermException() {
    }

    public OutOfRangeFiboTermException(String s) {
        super(s);
    }

    public OutOfRangeFiboTermException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public OutOfRangeFiboTermException(Throwable throwable) {
        super(throwable);
    }
}
