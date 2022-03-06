package br.com.marques.userapi.controllers.exceptions;

import br.com.marques.userapi.services.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<StandardError> UserNotFound(UserNotFoundException exception, HttpServletRequest request){
        StandardError error = new StandardError(
                LocalDateTime.now(),
                exception.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                request.getRequestURI());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
