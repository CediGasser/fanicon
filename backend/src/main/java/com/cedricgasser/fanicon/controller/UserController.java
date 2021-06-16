package com.cedricgasser.fanicon.controller;

import com.cedricgasser.fanicon.dto.DesignDto;
import com.cedricgasser.fanicon.model.User;
import com.cedricgasser.fanicon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
@PreAuthorize("hasAuthority('NORMAL') or hasAuthority('VIP') or hasAuthority('ADMIN')")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{name}/designs")
    public List<DesignDto> getDesignsFromUser(@PathVariable final String name) {
        return userService.getDesignsFromUser(name);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<User> getAll() { return userService.getAll(); }
}
