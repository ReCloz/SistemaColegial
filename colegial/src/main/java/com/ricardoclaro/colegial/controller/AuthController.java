package com.ricardoclaro.colegial.controller;

import com.ricardoclaro.colegial.dto.LoginDto;
import com.ricardoclaro.colegial.dto.TokenDto;
import com.ricardoclaro.colegial.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.ricardoclaro.colegial.common.SecurityConstants.AUTH_ENDPOINT;

@RestController
@CrossOrigin
@RequestMapping(AUTH_ENDPOINT)
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public TokenDto login(@RequestBody @Valid LoginDto dto) throws Exception {
        return authService.login(dto);
    }
}