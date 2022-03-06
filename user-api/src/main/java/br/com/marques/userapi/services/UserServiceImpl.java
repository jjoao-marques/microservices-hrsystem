package br.com.marques.userapi.services;

import br.com.marques.userapi.domain.User;
import br.com.marques.userapi.repositories.UserRepository;
import br.com.marques.userapi.services.exceptions.UserNotFoundException;
import br.com.marques.userapi.utils.MessageUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    private final Environment env;

    @Override
    public User findById(Long id) {
        log.info("USER_SERVICE ::: Get request on " + env.getProperty("local.server.port") + " port");
        return userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException(MessageUtil.USER_NOT_FOUND ));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
