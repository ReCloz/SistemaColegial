package com.ricardoclaro.colegial.controller;

import com.ricardoclaro.colegial.dto.MessageResponseDto;
import com.ricardoclaro.colegial.dto.UserDto;
import com.ricardoclaro.colegial.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/users") //Endpoint para criação do usuário
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public MessageResponseDto create(@RequestBody @Valid UserDto dto) {
        return userService.create(dto);
    }
}