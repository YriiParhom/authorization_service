package ru.netology.autorization_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.autorization_service.exception.InvalidCredentials;
import ru.netology.autorization_service.exception.UnauthorizedUser;
import ru.netology.autorization_service.model.Authorities;
import ru.netology.autorization_service.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {

    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        try {
            if (user.length() < 2 || password.length() < 3) {
                throw new InvalidCredentials("Invalid credentials exception");
            }
            return service.getAuthorities(user, password);
        } catch (UnauthorizedUser e) {
            throw new UnauthorizedUser("Unauthorized user");
        }
    }
}
