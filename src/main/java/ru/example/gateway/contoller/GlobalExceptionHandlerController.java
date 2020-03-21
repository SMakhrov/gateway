package ru.example.gateway.contoller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.example.gateway.util.CustomException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.AccessDeniedException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandlerController {
    @ExceptionHandler(CustomException.class)
    public void handleCustomException(HttpServletResponse res, CustomException e) throws IOException {
        log.error("ERROR", e);
        res.sendError(e.getHttpStatus().value(), e.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public void handleAccessDeniedException(HttpServletResponse res, AccessDeniedException e) throws IOException {
        log.error("ERROR", e);
        res.sendError(HttpStatus.FORBIDDEN.value(), "Access denied");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public void handleIllegalArgumentException(HttpServletResponse res, IllegalArgumentException e) throws IOException {
        log.error("ERROR", e);
        res.sendError(HttpStatus.BAD_REQUEST.value(), "Something went wrong");
    }

    @ExceptionHandler(Exception.class)
    public void handleException(HttpServletResponse res, Exception e) throws IOException {
        log.error("ERROR", e);
        res.sendError(HttpStatus.BAD_REQUEST.value(), "Something went wrong");
    }


}