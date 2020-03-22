package ru.example.gateway.util.exception.jwt;
import ru.example.gateway.util.exception.ApplicationException;
import ru.example.gateway.util.exception.ErrorType;

public class JwtClaimsIsEmptyException extends ApplicationException {
    public static final String JWT_CLAIMS_IS_EMPTY_EXCEPTION = "exception.common.jwtClaimsIsEmpty";

    public JwtClaimsIsEmptyException() {
        super(ErrorType.UNAUTHORIZED, JWT_CLAIMS_IS_EMPTY_EXCEPTION);
    }
}
