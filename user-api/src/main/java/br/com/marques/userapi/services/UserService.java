package br.com.marques.userapi.services;

import br.com.marques.userapi.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User findById(Long id);
    List<User> findAll();
}
