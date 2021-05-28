package com.cedricgasser.fanicon.controller;

import com.cedricgasser.fanicon.auth.PgAuthenticationProvider;
import com.cedricgasser.fanicon.dto.UserDto;
import com.cedricgasser.fanicon.model.User;
import com.cedricgasser.fanicon.model.UserGroup;
import com.cedricgasser.fanicon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    private final UserService userService;
    private final PgAuthenticationProvider authenticationProvider;

    @Autowired
    public AuthController(UserService userService, PgAuthenticationProvider authenticationProvider) {
        this.userService = userService;
        this.authenticationProvider = authenticationProvider;
    }

    @PostMapping("/register")
    public User register(@RequestBody final User user){
        return userService.register(user);
    }

    @PostMapping("/login")
    public void login(@RequestBody final UserDto loginRequest){
        final Authentication authentication = authenticationProvider.login(loginRequest);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
