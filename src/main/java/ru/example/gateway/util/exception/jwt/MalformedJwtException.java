package ru.example.gateway.util.exception.jwt;
import ru.example.gateway.util.exception.ApplicationException;
import ru.example.gateway.util.exception.ErrorType;

public class MalformedJwtException extends ApplicationException {
    public static final String MALFORMED_JWT_EXCEPTION = "exception.common.malformedJwt";

    public MalformedJwtException() {
        super(ErrorType.UNAUTHORIZED, MALFORMED_JWT_EXCEPTION);
    }
}
