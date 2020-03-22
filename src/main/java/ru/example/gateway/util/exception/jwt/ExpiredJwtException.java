package ru.example.gateway.util.exception.jwt;
import ru.example.gateway.util.exception.ApplicationException;
import ru.example.gateway.util.exception.ErrorType;

public class ExpiredJwtException extends ApplicationException {
    public static final String EXPIRED_JWT_EXCEPTION = "exception.common.expiredJwt";

    public ExpiredJwtException() {
        super(ErrorType.UNAUTHORIZED, EXPIRED_JWT_EXCEPTION);
    }
}
