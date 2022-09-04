package ru.netology.autorization_service.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.autorization_service.exception.InvalidCredentials;
import ru.netology.autorization_service.exception.UnauthorizedUser;

@RestControllerAdvice()
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invCredException(InvalidCredentials e) {
        return new ResponseEntity<>("Invalid Credentials Exception", HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedUser(UnauthorizedUser e) {
        return new ResponseEntity<>("Unauthorized User Exception", HttpStatus.NOT_FOUND);
    }
}
