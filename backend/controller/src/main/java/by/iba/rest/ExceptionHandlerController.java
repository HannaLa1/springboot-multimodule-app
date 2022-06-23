package by.iba.rest;

import by.iba.exception.ErrorMessage;
import by.iba.exception.ResourceNotFoundException;
import by.iba.exception.ServiceException;
import by.iba.exception.TokenExpiredException;
import by.iba.security.exception.BannedUserException;
import by.iba.security.exception.WrongPassword;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public interface ExceptionHandlerController {

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request);

    @ExceptionHandler(ServiceException.class)
    ResponseEntity<ErrorMessage> isExistException(ServiceException ex, WebRequest request);

    @ExceptionHandler(WrongPassword.class)
    ResponseEntity<ErrorMessage> wrongPasswordException(WrongPassword ex, WebRequest request);

    @ExceptionHandler(TokenExpiredException.class)
    ResponseEntity<ErrorMessage> tokenExpiredException(TokenExpiredException ex, WebRequest request);

    @ExceptionHandler(BannedUserException.class)
    ResponseEntity<ErrorMessage> bannedUserException(BannedUserException ex, WebRequest request);
}
