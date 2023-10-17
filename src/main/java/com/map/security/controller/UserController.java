package com.map.security.controller;

import com.map.security.entity.User;
import com.map.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Optional<User> getUserById(@PathVariable("id") Integer id) {
        return userService.findUserById(id);
    }

    @GetMapping(path = "/list")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<User> getUsers() {
        return userService.getUsers();
    }
}
