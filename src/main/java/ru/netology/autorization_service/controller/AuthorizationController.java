package ru.netology.autorization_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.netology.autorization_service.exception.InvalidCredentials;
import ru.netology.autorization_service.exception.UnauthorizedUser;
import ru.netology.autorization_service.model.Authorities;
import ru.netology.autorization_service.model.User;
import ru.netology.autorization_service.service.AuthorizationService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AuthorizationController {

    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        try {
            return service.getAuthorities(user);
        } catch (UnauthorizedUser e) {
            throw new UnauthorizedUser("Unauthorized user");
        } catch (InvalidCredentials e) {
            throw new InvalidCredentials("Invalid credentials exception");
        }
    }
}
