package com.ricardoclaro.colegial.service.auth;

import com.ricardoclaro.colegial.dto.LoginDto;
import com.ricardoclaro.colegial.dto.TokenDto;

public interface AuthService {

    public TokenDto login(LoginDto dto) throws Exception;
}