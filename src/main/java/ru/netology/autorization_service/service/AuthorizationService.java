package ru.netology.autorization_service.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.netology.autorization_service.exception.InvalidCredentials;
import ru.netology.autorization_service.exception.UnauthorizedUser;
import ru.netology.autorization_service.model.Authorities;
import ru.netology.autorization_service.model.User;
import ru.netology.autorization_service.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        if (isEmpty(user.getName()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}