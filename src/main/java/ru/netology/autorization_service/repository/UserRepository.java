package ru.netology.autorization_service.repository;

import org.springframework.stereotype.Repository;
import ru.netology.autorization_service.model.Authorities;
import ru.netology.autorization_service.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(User user) {
        List<Authorities> authorities = new ArrayList<>();
        if (user.getName().equals("admin") && user.getPassword().equals("111")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        } else if (user.getName().equals("manager") && user.getPassword().equals("222")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        } else if (user.getName().equals("yurec") && user.getPassword().equals("123")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        }
        return authorities;
    }
}
