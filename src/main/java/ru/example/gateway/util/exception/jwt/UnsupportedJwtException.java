package ru.example.gateway.util.exception.jwt;
import ru.example.gateway.util.exception.ApplicationException;
import ru.example.gateway.util.exception.ErrorType;

public class UnsupportedJwtException extends ApplicationException {
    public static final String UNSUPPORTED_JWT_EXCEPTION = "exception.common.unsupportedJwt";

    public UnsupportedJwtException() {
        super(ErrorType.UNAUTHORIZED, UNSUPPORTED_JWT_EXCEPTION);
    }
}
