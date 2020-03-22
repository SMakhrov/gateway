package ru.example.gateway.util.exception.jwt;
import ru.example.gateway.util.exception.ApplicationException;
import ru.example.gateway.util.exception.ErrorType;

public class InvalidSignatureException extends ApplicationException {
    public static final String INVALID_SIGNATURE_EXCEPTION = "exception.common.invalidSignature";

    public InvalidSignatureException() {
        super(ErrorType.UNAUTHORIZED, INVALID_SIGNATURE_EXCEPTION);
    }
}
