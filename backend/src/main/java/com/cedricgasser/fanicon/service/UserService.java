package com.cedricgasser.fanicon.service;

import com.cedricgasser.fanicon.dto.DesignDto;
import com.cedricgasser.fanicon.model.Design;
import com.cedricgasser.fanicon.model.User;
import com.cedricgasser.fanicon.model.UserGroup;
import com.cedricgasser.fanicon.repository.DesignRepository;
import com.cedricgasser.fanicon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final DesignRepository designRepository;
    private final DesignService designService;

    @Autowired
    public UserService(UserRepository userRepository, DesignRepository designRepository, DesignService designService) {
        this.userRepository = userRepository;
        this.designRepository = designRepository;
        this.designService = designService;
    }

    @Transactional(readOnly = true)
    public Optional<UserGroup> login(final String name, final String password) {

        User user = userRepository.checkPassword(name, password);

        if (user == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Password or Username incorrect", new Exception("Password or Username incorrect"));
        }

        return Optional.of(user.getUserGroup());
    }

    @Transactional
    public UserGroup upgradeToVip() {
        final SecurityContext context = SecurityContextHolder.getContext();
        User oldUser = userRepository.getByName(context.getAuthentication().getName());
        userRepository.changeUserGroup(oldUser.getName(), UserGroup.VIP);

        return userRepository.getByName(oldUser.getName()).getUserGroup();
    }

    @Transactional
    public User register(final User user) {
        user.setUserGroup(UserGroup.NORMAL);
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public List<DesignDto> getDesignsFromUser(final String name) {
        List<Design> designs = designRepository.getAllByUser(userRepository.findById(name).orElseThrow());
        List<DesignDto> designDtos = new ArrayList();
        for (Design design: designs) {
            designDtos.add(new DesignDto(design.getId(), design.getName(), design.getBgColor(), design.getIconSize(), design.getIconMargin(), design.getIconColor(), design.getUser().getName(), designService.getIconsFromDesignId(design.getId())));
        }
        return designDtos;
    }

    @Transactional(readOnly = true)
    public List<User> getAll(){
        Iterable<User> users = userRepository.findAll();
        List<User> userList = StreamSupport
                .stream(users.spliterator(), false)
                .collect(Collectors.toList());

        for (User user: userList) {
            user.setPassword("");
        }
        return userList;
    }
}
