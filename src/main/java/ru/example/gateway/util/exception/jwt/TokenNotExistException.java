package ru.example.gateway.util.exception.jwt;
import ru.example.gateway.util.exception.ApplicationException;
import ru.example.gateway.util.exception.ErrorType;

public class TokenNotExistException extends ApplicationException {
    public static final String TOKEN_NOT_EXIST_EXCEPTION = "exception.common.tokenNotExist";

    public TokenNotExistException() {
        super(ErrorType.UNAUTHORIZED, TOKEN_NOT_EXIST_EXCEPTION);
    }
}
