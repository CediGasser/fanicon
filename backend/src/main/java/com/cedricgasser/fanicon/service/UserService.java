package com.cedricgasser.fanicon.service;

import com.cedricgasser.fanicon.model.User;
import com.cedricgasser.fanicon.model.UserGroup;
import com.cedricgasser.fanicon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public Optional<UserGroup> login(final String name, final String password) {

        User user = userRepository.checkPassword(name, password);
        return Optional.of(user.getUserGroup());
    }

    @Transactional
    public User register(final User user) {
        user.setUserGroup(UserGroup.NORMAL);
        return userRepository.save(user);
    }
}
